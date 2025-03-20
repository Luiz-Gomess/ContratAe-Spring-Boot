package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.dto.CandidatoDTO;
import com.securitas.contratae.api.dto.VagaDTO;
import com.securitas.contratae.api.exception.BusinessException;
import com.securitas.contratae.api.exception.ResourceNotFoundException;
import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.repository.CandidatoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepositorio candidatoRepositorio;

    @Autowired
    private VagaService vagaService;


    public List<CandidatoDTO> listarCandidatos(){
        return candidatoRepositorio.findAll().stream().map(CandidatoDTO::new).toList();
    }

    public List<VagaDTO> listarCandidaturas(String cpf){
        Candidato candidato = buscarCandidatoPorCpf(cpf);
        return candidato.getCandidaturas().stream().map(VagaDTO::new).toList();
    }

    @Transactional
    public Candidato salvarCandidato(Candidato candidato){
        try{
            buscarCandidatoPorCpf(candidato.getCpf());
            throw new BusinessException("Candidato já cadastrado");
            
        } catch (ResourceNotFoundException e){
            return candidatoRepositorio.save(candidato);
        }
    }


    public Candidato buscarCandidatoPorCpf(String cpf){ 
        validarCPF(cpf);
        return candidatoRepositorio.findById(cpf).orElseThrow(() -> new ResourceNotFoundException("Candidato não encontrado"));
    }

    public CandidatoDTO buscarCandidatoDTO(String cpf){
        Candidato candidato = buscarCandidatoPorCpf(cpf);
        return new CandidatoDTO(candidato);
    }


    @Transactional
    public void deletarCandidato(String cpf){
        buscarCandidatoPorCpf(cpf);
        this.candidatoRepositorio.deleteById(cpf);
    }

    @Transactional
    public Candidato atualizarCandidato(Candidato candidato){
        return candidatoRepositorio.save(candidato);
    }

    @Transactional
    public void candidatar(String cpf, Integer vagaId) {
        Candidato candidato = this.buscarCandidatoPorCpf(cpf); 
        Vaga vaga = this.vagaService.buscarVaga(vagaId);

        if(candidato.getCandidaturas().contains(vaga)){
            throw new BusinessException("Candidato já está inscrito nesta vaga.");
        }
    
        candidato.candidatar(vaga);
        vaga.candidatar(candidato);

        candidatoRepositorio.save(candidato);
    }

    
    @Transactional
    public void removerCandidatura(String cpf, Integer vagaId){
        Candidato candidato = this.buscarCandidatoPorCpf(cpf);
        Vaga vaga = this.vagaService.buscarVaga(vagaId);

        if(!candidato.getCandidaturas().contains(vaga)){
            throw new BusinessException("Candidato não está inscrito nesta vaga");
        }

        candidato.removerCandidatura(vaga);
        vaga.removerCandidatura(candidato);

        candidatoRepositorio.save(candidato);
    }


    private boolean validarCPF(String cpf){
		if(!cpf.matches("\\d+")){
			throw new BusinessException("CPF deve conter apenas números");
		}
		else{
			return true;
		}
	}

    
}

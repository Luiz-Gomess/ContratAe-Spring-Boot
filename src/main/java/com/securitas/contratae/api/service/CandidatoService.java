package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.model.CandidatoDTOs.CandidatoListagemDTO;
import com.securitas.contratae.api.repository.CandidatoRepositorio;
import com.securitas.contratae.api.repository.VagaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepositorio candidatoRepositorio;

    @Autowired
    private VagaRepositorio vagaRepositorio;

    public List<CandidatoListagemDTO> listarCandidatos(){
        return candidatoRepositorio.findAll().stream().map(CandidatoListagemDTO::new).toList();
    }

    public List<Vaga> listarCandidaturas(String cpf){
        return candidatoRepositorio.getCandidaturas(cpf);
    }

    @Transactional
    public Candidato salvarCandidato(Candidato candidato){
        return candidatoRepositorio.save(candidato);
    }

    public Candidato buscarCandidatoPorCpf(String cpf){
        return candidatoRepositorio.findById(cpf).orElse(null); 
    }

    @Transactional
    public void deletarCandidato(String cpf){
        candidatoRepositorio.deleteById(cpf);
    }

    @Transactional
    public Candidato atualizarCandidato(Candidato candidato){
        return candidatoRepositorio.save(candidato);
    }

    @Transactional
    public void candidatar(String cpf, Integer vagaId) {
        Candidato candidato = candidatoRepositorio.findById(cpf).orElse(null); 
        if(candidato != null){
            candidato.candidatar(vagaRepositorio.findById(vagaId).orElse(null));
            candidatoRepositorio.save(candidato);
        }
    }

    
}

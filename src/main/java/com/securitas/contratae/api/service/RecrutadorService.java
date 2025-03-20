package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.exception.BusinessException;
import com.securitas.contratae.api.exception.ResourceNotFoundException;
import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorListagemDTO;
import com.securitas.contratae.api.model.VagaDTOs.VagaDTO;
import com.securitas.contratae.api.repository.RecrutadorRepositorio;

import jakarta.transaction.Transactional;

@Service
public class RecrutadorService {

    @Autowired
    private RecrutadorRepositorio recrutadorRepositorio;

    public List<RecrutadorListagemDTO> listarRecrutadores(){
        return recrutadorRepositorio.findAll().stream().map(RecrutadorListagemDTO::new).toList();
    }

    public List<VagaDTO> listarVagasGerenciadas(String cpf){
        Recrutador recrutador = this.buscarRecrutador(cpf);
        return recrutador.getVagasGerenciadas().stream().map(VagaDTO::new).toList();
    }
    
    public RecrutadorListagemDTO buscarRecrutadorDTO(String cpf){
        Recrutador recrutador = this.buscarRecrutador(cpf);
        RecrutadorListagemDTO recrutadorDTO = new RecrutadorListagemDTO(recrutador);
        
        return recrutadorDTO;
    }

    @Transactional
    public Recrutador salvarRecrutador(Recrutador recrutador){
        return recrutadorRepositorio.save(recrutador);
    }

    @Transactional
    public void deletarRecrutador(String cpf){
        buscarRecrutador(cpf);
        recrutadorRepositorio.deleteById(cpf);
    }


    //Métodos auxiliares
    private boolean validarCPF(String cpf){
		if(!cpf.matches("\\d+"))
			throw new BusinessException("CPF deve conter apenas números");	
		else
			return true;
	}

    public Recrutador buscarRecrutador(String cpf){
        validarCPF(cpf);
        return this.recrutadorRepositorio.findById(cpf).orElseThrow(() -> new ResourceNotFoundException("Recrutador não encontrado"));
    }
}

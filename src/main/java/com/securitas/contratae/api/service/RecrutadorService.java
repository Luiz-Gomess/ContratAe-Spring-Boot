package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorDTO;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorListagemDTO;
import com.securitas.contratae.api.repository.RecrutadorRepositorio;

@Service
public class RecrutadorService {

    @Autowired
    private RecrutadorRepositorio recrutadorRepositorio;

    public List<RecrutadorListagemDTO> listarRecrutadores(){
        return recrutadorRepositorio.findAll().stream().map(RecrutadorListagemDTO::new).toList();
    }

    public RecrutadorDTO buscarRecrutadorPorCpf(String cpf){
        Recrutador recrutador = recrutadorRepositorio.findById(cpf).orElse(null);
        RecrutadorDTO recrutadorDTO = new RecrutadorDTO(recrutador);
        
        return recrutadorDTO;
    }

    public Recrutador buscarRecrutador(String cpf){
        return recrutadorRepositorio.findById(cpf).orElse(null);
    }

    public Recrutador salvarRecrutador(Recrutador recrutador){
        return recrutadorRepositorio.save(recrutador);
    }
}

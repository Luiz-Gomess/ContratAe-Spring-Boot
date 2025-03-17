package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.repository.RecrutadorRepositorio;

@Service
public class RecrutadorService {

    @Autowired
    private RecrutadorRepositorio recrutadorRepositorio;

    public List<Recrutador> listarRecrutadores(){
        return recrutadorRepositorio.findAll();
    }

    public Recrutador salvarRecrutador(Recrutador recrutador){
        return recrutadorRepositorio.save(recrutador);
    }
}

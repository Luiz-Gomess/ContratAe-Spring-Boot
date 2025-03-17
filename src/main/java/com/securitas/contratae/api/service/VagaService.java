package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.repository.VagaRepositorio;

@Service
public class VagaService {
    
    @Autowired
    private VagaRepositorio vagaRepositorio;

    public List<Vaga >listarVagas() {
        return this.vagaRepositorio.findAll();
    }

    public Vaga salvarVaga(Vaga vaga) {
        return this.vagaRepositorio.save(vaga);
    }
}

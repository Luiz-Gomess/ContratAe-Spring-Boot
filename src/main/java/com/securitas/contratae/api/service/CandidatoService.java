package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.repository.CandidatoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepositorio candidatoRepositorio;

    public List<Candidato> listarCandidatos(){
        return candidatoRepositorio.findAll();
    }

    @Transactional
    public Candidato salvarCandidato(Candidato candidato){
        return candidatoRepositorio.save(candidato);
    }
}

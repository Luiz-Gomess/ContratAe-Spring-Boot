package com.securitas.contratae.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.service.CandidatoService;

@RestController
@RequestMapping("/")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/candidatos")
    public List<Candidato> listarCandidatos(){
        return this.candidatoService.listarCandidatos();
    }

    @PostMapping("/candidatos")
    public Candidato salvarCandidato(@RequestBody Candidato candidato){
        return this.candidatoService.salvarCandidato(candidato);
    }


}

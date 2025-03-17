package com.securitas.contratae.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.service.VagaService;

@RestController
@RequestMapping("/")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping("/vagas")
    public List<Vaga> listarVagas() {
        return this.vagaService.listarVagas();
    }

    @PostMapping("/vagas")
    public Vaga salvarVaga(@RequestBody Vaga vaga) {
        return this.vagaService.salvarVaga(vaga);
    }
}

package com.securitas.contratae.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.model.CandidatoDTOs.CandidatoListagemDTO;
import com.securitas.contratae.api.service.CandidatoService;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public List<CandidatoListagemDTO> listarCandidatos() {
        return this.candidatoService.listarCandidatos();
    }

    @GetMapping("/candidaturas/{cpf}")
    public List<Vaga> listarCandidaturas(@PathVariable String cpf){
        return this.candidatoService.listarCandidaturas(cpf);
    }

    @PostMapping
    public Candidato salvarCandidato(@RequestBody Candidato candidato) {
        return this.candidatoService.salvarCandidato(candidato);
    }

    @GetMapping("/{cpf}")
    public Candidato buscarCandidatoPorCpf(@PathVariable String cpf) {
        System.out.println(cpf);
        return this.candidatoService.buscarCandidatoPorCpf(cpf);
    }

    @PutMapping("/{cpf}")
    public Candidato atualizarCandidato(@RequestBody Candidato candidato) {
        return this.candidatoService.atualizarCandidato(candidato);
    }

    @DeleteMapping("/{cpf}")
    public void deletarCandidato(@PathVariable String cpf) {
        this.candidatoService.deletarCandidato(cpf);
    }

    @PostMapping("/{cpf}/candidatar/{vagaId}")
    public ResponseEntity<String> candidatar(@PathVariable String cpf, @PathVariable Integer vagaId) {
        candidatoService.candidatar(cpf, vagaId);
        return ResponseEntity.ok("Candidatura realizada com sucesso!");
    }
}

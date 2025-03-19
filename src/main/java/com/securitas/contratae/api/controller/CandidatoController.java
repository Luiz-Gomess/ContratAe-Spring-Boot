package com.securitas.contratae.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.securitas.contratae.api.model.CandidatoDTOs.CandidatoListagemDTO;
import com.securitas.contratae.api.model.VagaDTOs.VagaDTO;
import com.securitas.contratae.api.service.CandidatoService;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public ResponseEntity<Map<String, ?>> salvarCandidato(@RequestBody Candidato candidato) {
        Candidato c = this.candidatoService.salvarCandidato(candidato);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("message", "Candidato salvo com sucesso!", "candidato", c));
    }

    @GetMapping
    public List<CandidatoListagemDTO> listarCandidatos() {
        return this.candidatoService.listarCandidatos();
    }

    @GetMapping("/candidaturas/{cpf}")
    public List<VagaDTO> listarCandidaturas(@PathVariable String cpf){
        return this.candidatoService.listarCandidaturas(cpf);
    }

    @GetMapping("/{cpf}")
    public CandidatoListagemDTO buscarCandidatoPorCpf(@PathVariable String cpf) {
        return this.candidatoService.buscarCandidatoDTO(cpf);
        
    }

    @PutMapping("/{cpf}")
    public Candidato atualizarCandidato(@RequestBody Candidato candidato) {
        return this.candidatoService.atualizarCandidato(candidato);
    }

    @PutMapping("/{cpf}/candidatar/{vagaId}")
    public ResponseEntity<Map<String, String>> candidatar(@PathVariable String cpf, @PathVariable Integer vagaId) {
        candidatoService.candidatar(cpf, vagaId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Candidatura realizada com sucesso!"));
    }

    @PutMapping("/{cpf}/removercandidatura/{vagaId}")
    public ResponseEntity<Map<String, String>> removerCandidatura(@PathVariable String cpf, @PathVariable Integer vagaId) {
        candidatoService.removerCandidatura(cpf, vagaId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Candidatura removida com sucesso!"));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Map<String, String>> deletarCandidato(@PathVariable String cpf) {
        this.candidatoService.deletarCandidato(cpf);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Candidato deletado com sucesso!"));
    }

}

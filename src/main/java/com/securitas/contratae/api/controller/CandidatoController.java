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

import com.securitas.contratae.api.dto.CandidatoDTO;
import com.securitas.contratae.api.dto.VagaDTO;
import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.service.CandidatoService;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    //ok
    @PostMapping
    public ResponseEntity<Map<String, ?>> salvarCandidato(@RequestBody Candidato candidato) {
        Candidato c = this.candidatoService.salvarCandidato(candidato);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("message", "Candidato salvo com sucesso!", "candidato", c));
    }

    //ok
    @GetMapping
    public List<CandidatoDTO> listarCandidatos() {
        return this.candidatoService.listarCandidatos();
    }

    //ok
    // @GetMapping("/candidaturas/{cpf}")
    // public List<VagaDTO> listarCandidaturas(@PathVariable String cpf){
    //     return this.candidatoService.listarCandidaturas(cpf);
    // }

    @GetMapping("/candidaturas/{cpf}")
    public ResponseEntity<List<VagaDTO>> listarCandidaturas(@PathVariable String cpf){
        List<VagaDTO> candidaturas = this.candidatoService.listarCandidaturas(cpf);
        HttpStatus status = candidaturas.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity
                .status(status)
                .body(candidaturas);
    }

    //ok
    @GetMapping("/{cpf}")
    public CandidatoDTO buscarCandidatoPorCpf(@PathVariable String cpf) {
        return this.candidatoService.buscarCandidatoDTO(cpf);
    }

    //ok
    @PutMapping
    public Candidato atualizarCandidato(@RequestBody Candidato candidato) {
        return this.candidatoService.atualizarCandidato(candidato);
    }

    //ok
    @PutMapping("/{cpf}/candidatar/{vagaId}")
    public ResponseEntity<Map<String, String>> candidatar(@PathVariable String cpf, @PathVariable Integer vagaId) {
        candidatoService.candidatar(cpf, vagaId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Candidatura realizada com sucesso!"));
    }

    //ok
    @PutMapping("/{cpf}/removercandidatura/{vagaId}")
    public ResponseEntity<Map<String, String>> removerCandidatura(@PathVariable String cpf, @PathVariable Integer vagaId) {
        candidatoService.removerCandidatura(cpf, vagaId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Candidatura removida com sucesso!"));
    }

    //ok
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Map<String, String>> deletarCandidato(@PathVariable String cpf) {
        this.candidatoService.deletarCandidato(cpf);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Candidato deletado com sucesso!"));
    }

}

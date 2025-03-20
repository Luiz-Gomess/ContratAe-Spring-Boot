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

import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorListagemDTO;
import com.securitas.contratae.api.model.VagaDTOs.VagaDTO;
import com.securitas.contratae.api.service.RecrutadorService;

@RestController
@RequestMapping("/recrutadores")
public class RecrutadorController {

    @Autowired
    private RecrutadorService recrutadorService;

    //ok
    @GetMapping
    public List<RecrutadorListagemDTO> listarRecrutadores(){
        return this.recrutadorService.listarRecrutadores();
    }

    //ok
    @GetMapping("/{cpf}")
    public RecrutadorListagemDTO buscarRecrutadorPorCpf(@PathVariable String cpf) {
        return this.recrutadorService.buscarRecrutadorDTO(cpf);
    }

    //ok
    @GetMapping("/{cpf}/vagas")
    public List<VagaDTO> listarVagasGerenciadas(@PathVariable String cpf){
        return this.recrutadorService.listarVagasGerenciadas(cpf);
    }

    //ok
    @PostMapping
    public Recrutador salvarRecrutador(@RequestBody Recrutador recrutador){
        return this.recrutadorService.salvarRecrutador(recrutador);
    }

    //ok
    @PutMapping
    public Recrutador atualizarRecrutador(@RequestBody Recrutador recrutador){
        return this.recrutadorService.salvarRecrutador(recrutador);
    }

    //ok
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Map<String, String>> deletarRecrutador(@PathVariable String cpf){
        this.recrutadorService.deletarRecrutador(cpf);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Recrutador deletado com sucesso!"));
    }
}

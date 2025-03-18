package com.securitas.contratae.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorDTO;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorListagemDTO;
import com.securitas.contratae.api.service.RecrutadorService;

@RestController
@RequestMapping("/recrutadores")
public class RecrutadorController {

    @Autowired
    private RecrutadorService recrutadorService;

    @GetMapping
    public List<RecrutadorListagemDTO> listarRecrutadores(){
        return this.recrutadorService.listarRecrutadores();
    }

    @GetMapping("/{cpf}")
    public RecrutadorDTO buscarRecrutadorPorCpf(@PathVariable String cpf) {
        return this.recrutadorService.buscarRecrutadorPorCpf(cpf);
    }

    @PostMapping
    public Recrutador salvarRecrutador(@RequestBody Recrutador recrutador){
        return this.recrutadorService.salvarRecrutador(recrutador);
    }
}

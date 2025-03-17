package com.securitas.contratae.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.service.RecrutadorService;

@RestController
@RequestMapping("/")
public class RecrutadorController {

    @Autowired
    private RecrutadorService recrutadorService;

    @GetMapping("/recrutadores")
    public List<Recrutador> listarRecrutadores(){
        return this.recrutadorService.listarRecrutadores();
    }

    @PostMapping("/recrutadores")
    public Recrutador salvarRecrutador(@RequestBody Recrutador recrutador){
        return this.recrutadorService.salvarRecrutador(recrutador);
    }
}

package com.securitas.contratae.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.model.CandidatoDTOs.CandidatoListagemDTO;
import com.securitas.contratae.api.model.VagaDTOs.VagaDTO;
import com.securitas.contratae.api.service.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<VagaDTO> listarVagas() {
        return this.vagaService.listarVagas();
    }

    @GetMapping("/{id}/candidaturas")
    public List<CandidatoListagemDTO> listarCandidaturas(@PathVariable Integer id){
        return this.vagaService.listarCandidaturas(id);
    }

    @GetMapping("/{id}")
    public VagaDTO buscarVagaPorId(@PathVariable Integer id) {
        return this.vagaService.buscarVagaDTO(id);
    }

    @GetMapping("/buscar")
    public List<VagaDTO> buscarVagaPorFiltro(
        @RequestParam (required = false) String titulo, 
        @RequestParam (required = false) String salario){

        return this.vagaService.buscarVagaPorFiltro(titulo, salario);
    }



    @PostMapping
    public Vaga salvarVaga(@RequestBody Vaga vaga) {
        return this.vagaService.salvarVaga(vaga);
    }
}

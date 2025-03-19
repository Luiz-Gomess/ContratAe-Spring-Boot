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
        @RequestParam (required = false) Double salario){

        return this.vagaService.buscarVagaPorFiltro(titulo, salario);
    }

    @PostMapping
    public  ResponseEntity<Map<String, ?>> salvarVaga(@RequestBody Vaga vaga) {
        Vaga v = this.vagaService.salvarVaga(vaga);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("message", "Vaga salva com sucesso!", "vaga", v));
    }

    @PutMapping
    public Vaga atualizarCandidato(@RequestBody Vaga vaga) {
        return this.vagaService.salvarVaga(vaga);
    }

    @DeleteMapping("/{id}")
    public void deletarVaga(@PathVariable Integer id) {
        this.vagaService.deletarVaga(id);
    }
}

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

import com.securitas.contratae.api.dto.CandidatoDTO;
import com.securitas.contratae.api.dto.VagaDTO;
import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.service.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    //ok
    @GetMapping
    public List<VagaDTO> listarVagas() {
        return this.vagaService.listarVagas();
    }

    // //ok
    // @GetMapping("/{id}/candidaturas")
    // public List<CandidatoDTO> listarCandidaturas(@PathVariable Integer id){
    //     return this.vagaService.listarCandidaturas(id);
    // }

    @GetMapping("/{id}/candidaturas")
    public ResponseEntity<List<CandidatoDTO>> listarCandidaturas(@PathVariable Integer id){
        List<CandidatoDTO> candidatos = this.vagaService.listarCandidaturas(id);
        HttpStatus status = candidatos.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity
                .status(status)
                .body(candidatos);
    }

    //ok
    @GetMapping("/{id}")
    public VagaDTO buscarVagaPorId(@PathVariable Integer id) {
        return this.vagaService.buscarVagaDTO(id);
    }

    //ok
    @GetMapping("/buscar")
    public List<VagaDTO> buscarVagaPorFiltro(
        @RequestParam (required = false) String titulo, 
        @RequestParam (required = false) Double salario){

        return this.vagaService.buscarVagaPorFiltro(titulo, salario);
    }

    //ok
    @PostMapping
    public  ResponseEntity<Map<String, ?>> salvarVaga(@RequestBody Vaga vaga) {
        Vaga v = this.vagaService.salvarVaga(vaga);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("message", "Vaga salva com sucesso!", "vaga", v));
    }

    //ok
    @PutMapping
    public Vaga atualizarVaga(@RequestBody Vaga vaga) {
        return this.vagaService.salvarVaga(vaga);
    }

    //ok
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletarVaga(@PathVariable Integer id) {
        this.vagaService.deletarVaga(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", "Vaga deletada com sucesso!"));
    }
}

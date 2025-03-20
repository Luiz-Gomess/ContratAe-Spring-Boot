package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.dto.CandidatoDTO;
import com.securitas.contratae.api.dto.VagaDTO;
import com.securitas.contratae.api.exception.ResourceNotFoundException;
import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.repository.VagaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class VagaService {
    
    @Autowired
    private VagaRepositorio vagaRepositorio;

    public List<VagaDTO >listarVagas() {
        return this.vagaRepositorio.findAll().stream().map(VagaDTO::new).toList();
    }

    public List<CandidatoDTO> listarCandidaturas(Integer id){
        Vaga vaga = this.buscarVaga(id);
        return vaga.getCandidatos().stream().map(CandidatoDTO::new).toList();   
    }

    @Transactional
    public Vaga salvarVaga(Vaga vaga) {
        return this.vagaRepositorio.save(vaga);
    }

    @Transactional
    public void deletarVaga(Integer id) {
        buscarVaga(id);
        this.vagaRepositorio.delete(this.buscarVaga(id));
    }

    public Vaga buscarVaga(Integer id) {
        return this.vagaRepositorio
                    .findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrada."));
    }

    public VagaDTO buscarVagaDTO(Integer id) {

        Vaga vaga = this.buscarVaga(id);
        VagaDTO vagaDTO = new VagaDTO(vaga);

        return vagaDTO;
    }

    public List<VagaDTO> buscarVagaPorFiltro(String titulo, Double salario){

        Double sal = salario == null ? 0 : salario;
        return this.vagaRepositorio.
        findByFilter(sal, titulo)
        .stream()
        .map(VagaDTO::new).toList();
    }



    
}

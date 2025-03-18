package com.securitas.contratae.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.model.VagaDTOs.VagaDTO;
import com.securitas.contratae.api.model.VagaDTOs.VagaListagemDTO;
import com.securitas.contratae.api.repository.VagaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class VagaService {
    
    @Autowired
    private VagaRepositorio vagaRepositorio;

    public List<VagaListagemDTO >listarVagas() {
        return this.vagaRepositorio.findAll().stream().map(VagaListagemDTO::new).toList();
    }

    @Transactional
    public Vaga salvarVaga(Vaga vaga) {
        return this.vagaRepositorio.save(vaga);
    }

    public VagaDTO buscarVagaPorId(Integer id) {

        Vaga vaga = this.vagaRepositorio.findById(id).orElse(null);
        VagaDTO vagaDTO = new VagaDTO(vaga);

        return vagaDTO;
    }

    
}

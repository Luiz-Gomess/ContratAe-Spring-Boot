package com.securitas.contratae.api.model.VagaDTOs;

import com.securitas.contratae.api.model.Vaga;
import com.securitas.contratae.api.model.RecrutadorDTOs.RecrutadorListagemDTO;

public record VagaDTO(Integer id, String titulo, String descricao, double salario, String empresa, String local, RecrutadorListagemDTO recrutador) {
    public VagaDTO (Vaga vaga) {
        this(
            vaga.getId(), 
            vaga.getTitulo(), 
            vaga.getDescricao(), 
            vaga.getSalario(), 
            vaga.getEmpresa(), 
            vaga.getLocal(),
            new RecrutadorListagemDTO(vaga.getRecrutador())
            );
    }
}

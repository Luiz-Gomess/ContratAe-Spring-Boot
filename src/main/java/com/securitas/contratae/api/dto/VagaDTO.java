package com.securitas.contratae.api.dto;

import com.securitas.contratae.api.model.Vaga;

public record VagaDTO(Integer id, String titulo, String descricao, double salario, String empresa, String local, String nomeRecrutador) {
    public VagaDTO (Vaga vaga) {
        this(
            vaga.getId(),
            vaga.getTitulo(), 
            vaga.getDescricao(),
            vaga.getSalario(), 
            vaga.getEmpresa(), 
            vaga.getLocal(),
            vaga.getRecrutador().getNome()
            );
    }
}

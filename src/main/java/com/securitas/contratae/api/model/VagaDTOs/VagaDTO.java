package com.securitas.contratae.api.model.VagaDTOs;

import java.util.List;

import com.securitas.contratae.api.model.Vaga;

public record VagaDTO(Integer id, String titulo, String descricao, double salario, String empresa, List<String> requisitos, String local, String nomeRecrutador) {
    public VagaDTO (Vaga vaga) {
        this(
            vaga.getId(),
            vaga.getTitulo(), 
            vaga.getDescricao(),
            vaga.getSalario(), 
            vaga.getEmpresa(), 
            vaga.getRequisitos(),
            vaga.getLocal(),
            vaga.getRecrutador().getNome()
            );
    }
}

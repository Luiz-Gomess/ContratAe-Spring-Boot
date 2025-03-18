package com.securitas.contratae.api.model.VagaDTOs;

import com.securitas.contratae.api.model.Vaga;

public record VagaListagemDTO(Integer id, String titulo, String descricao, double salario, String empresa, String local) {
    public VagaListagemDTO (Vaga vaga) {
        this(vaga.getId(), vaga.getTitulo(), vaga.getDescricao(), vaga.getSalario(), vaga.getEmpresa(), vaga.getLocal());
    }
}

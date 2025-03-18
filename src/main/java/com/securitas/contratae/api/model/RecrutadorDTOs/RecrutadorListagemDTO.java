package com.securitas.contratae.api.model.RecrutadorDTOs;

import com.securitas.contratae.api.model.Recrutador;

public record RecrutadorListagemDTO(String cpf, String nome, String email, String empresa) {
    public RecrutadorListagemDTO(Recrutador recrutador) {
        this(recrutador.getCpf(), recrutador.getNome(), recrutador.getEmail(), recrutador.getEmpresa());
    }
}

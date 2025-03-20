package com.securitas.contratae.api.dto;

import com.securitas.contratae.api.model.Recrutador;

public record RecrutadorDTO(String cpf, String nome, String email, String empresa) {
    public RecrutadorDTO(Recrutador recrutador) {
        this(
            recrutador.getCpf(), 
            recrutador.getNome(), 
            recrutador.getEmail(), 
            recrutador.getEmpresa()
            );
    }
}

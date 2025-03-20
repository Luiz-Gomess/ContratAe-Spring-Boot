package com.securitas.contratae.api.dto;

import java.util.List;

import com.securitas.contratae.api.model.Candidato;

public record CandidatoDTO(String cpf, String nome, String email, List<String> habilidades ) {

    public CandidatoDTO( Candidato candidato){
        this(
            candidato.getCpf(), 
            candidato.getNome(), 
            candidato.getEmail(), 
            candidato.getHabilidades()
            );
    }
}

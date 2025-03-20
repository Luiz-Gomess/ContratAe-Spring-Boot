package com.securitas.contratae.api.model.CandidatoDTOs;

import java.util.List;

import com.securitas.contratae.api.model.Candidato;

public record CandidatoListagemDTO(String cpf, String nome, String email, List<String> habilidades, String senha ) {

    public CandidatoListagemDTO( Candidato candidato){
        this(
            candidato.getCpf(), 
            candidato.getNome(), 
            candidato.getEmail(), 
            candidato.getHabilidades(),
            candidato.getSenha()
            );
    }
}

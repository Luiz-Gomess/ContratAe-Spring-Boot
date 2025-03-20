package com.securitas.contratae.api.model.RecrutadorDTOs;

import java.util.List;

import com.securitas.contratae.api.model.Recrutador;
import com.securitas.contratae.api.model.VagaDTOs.VagaDTO;

public record RecrutadorDTO(String cpf, String nome, String email, String empresa, String senha, List<VagaDTO> vagasGerenciadas) { //
    public RecrutadorDTO(Recrutador recrutador) {
        this(
            recrutador.getCpf(),
            recrutador.getNome(), 
            recrutador.getEmail(), 
            recrutador.getEmpresa(),
            recrutador.getSenha(),
            recrutador.getVagasGerenciadas().stream().map(VagaDTO::new).toList());
    }
}

package com.securitas.contratae.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.securitas.contratae.api.model.Candidato;
import com.securitas.contratae.api.model.Vaga;

public interface CandidatoRepositorio extends JpaRepository<Candidato, String>{
        
    @Query("SELECT candidaturas FROM Candidato c  WHERE c.cpf = :cpf")
    public List<Vaga> getCandidaturas(String cpf);

}

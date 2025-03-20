package com.securitas.contratae.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.securitas.contratae.api.model.Candidato;

public interface CandidatoRepositorio extends JpaRepository<Candidato, String>{
        
}

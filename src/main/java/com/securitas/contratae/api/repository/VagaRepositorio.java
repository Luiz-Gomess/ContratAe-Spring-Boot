package com.securitas.contratae.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitas.contratae.api.model.Vaga;

public interface VagaRepositorio extends JpaRepository<Vaga, Integer> {
    
     List<Vaga> findByTituloContaining(String titulo);
}

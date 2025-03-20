package com.securitas.contratae.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.securitas.contratae.api.model.Vaga;

public interface VagaRepositorio extends JpaRepository<Vaga, Integer> {
    
    // List<Vaga> findByTituloContaining(String titulo);

    @Query("SELECT v FROM Vaga v Where (:salario is null or v.salario>=:salario) AND (:titulo is null or v.titulo like %:titulo%)")
    List<Vaga> findByFilter(double salario, String titulo);

}

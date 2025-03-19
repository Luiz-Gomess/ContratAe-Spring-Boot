package com.securitas.contratae.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.securitas.contratae.api.model.Recrutador;

public interface RecrutadorRepositorio extends JpaRepository<Recrutador, String> {
    
}

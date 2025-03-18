package com.securitas.contratae.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_candidato")
public class Candidato {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    @ElementCollection
    private List<String> habilidades;

    @ManyToMany(mappedBy = "candidaturas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Vaga> candidaturas;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(List<String> Habilidades) {
        this.habilidades = habilidades;
    }

    public List<Vaga> getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(List<Vaga> candidaturas) {
        this.candidaturas = candidaturas;
    }
}

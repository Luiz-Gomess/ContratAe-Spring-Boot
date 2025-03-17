package com.securitas.contratae.api.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_recrutador")
public class Recrutador {
    
    @Id
    private String cpf;
    private String senha;
    private String nome;
    private String email;
    private String empresa;

    @OneToMany(
        mappedBy = "recrutador",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Vaga> vagasGerenciadas;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha)  {
        this.senha = senha;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Vaga> getVagasGerenciadas() {
        return vagasGerenciadas;
    }

    public void setVagasGerenciadas(List<Vaga> vagasGerenciadas) {
        this.vagasGerenciadas = vagasGerenciadas;
    }

    
}

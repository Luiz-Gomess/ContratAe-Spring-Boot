package com.securitas.contratae.api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    private double salario;
    private String empresa;
    private String local;
    
    @ManyToOne
    private Recrutador recrutador;

    @ElementCollection
    private List<String> requisitos;

    @ManyToMany
    @JoinTable(name = "tb_candidato_vaga", joinColumns = @JoinColumn(name = "vaga_id"), inverseJoinColumns = @JoinColumn(name = "candidato_id"))
    private List<Candidato> candidatos;

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<String> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<String> requisitos) {
        this.requisitos = requisitos;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void candidatar(Candidato c) {
        this.candidatos.add(c);
        c.candidatar(this);
    }

    public void removerCandidatura(Candidato c) {
        this.candidatos.remove(c);
        c.removerCandidatura(this);
    }

    public Recrutador getRecrutador() {
        return this.recrutador;
    }

    public void setRecrutador(Recrutador recrutador) {
        this.recrutador = recrutador;
    }
}

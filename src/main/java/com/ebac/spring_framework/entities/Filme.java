package com.ebac.spring_framework.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "filme")
@Table(name = "filmes")
public class Filme implements Serializable {

    private static final long serializableVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFilme;
    private String titulo;
    private Integer ano;

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}

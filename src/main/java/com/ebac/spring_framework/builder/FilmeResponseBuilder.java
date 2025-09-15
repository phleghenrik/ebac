package com.ebac.spring_framework.builder;

import com.ebac.spring_framework.response.FilmeResponse;

public class FilmeResponseBuilder {

    private Integer id;
    private Integer ano;
    private String titulo;

    public static FilmeResponseBuilder create(){
        return new FilmeResponseBuilder();
    }

    public FilmeResponseBuilder id(Integer id){
        this.id = id;
        return this;
    }

    public FilmeResponseBuilder titulo(String titulo){
        this.titulo = titulo;
        return this;
    }

    public FilmeResponseBuilder ano(Integer ano){
        this.ano = ano;
        return this;
    }

    public FilmeResponse build(){
        
        FilmeResponse response = new FilmeResponse();
        response.setId(id);
        response.setTitulo(titulo);
        response.setAno(ano);
        return response;
    }
}

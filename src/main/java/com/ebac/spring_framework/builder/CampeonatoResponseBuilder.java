package com.ebac.spring_framework.builder;

import com.ebac.spring_framework.response.CampeonatoResponse;

public class CampeonatoResponseBuilder {

    private Integer id;
    private Integer ano;
    private String nome;
    private String pais;

    public static CampeonatoResponseBuilder create(){
        return new CampeonatoResponseBuilder();
    }

    public CampeonatoResponseBuilder id(Integer id){
        this.id = id;
        return this;
    }

    public CampeonatoResponseBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public CampeonatoResponseBuilder ano(Integer ano){
        this.ano = ano;
        return this;
    }

    public CampeonatoResponseBuilder pais(String pais){
        this.pais = pais;
        return this;
    }

    public CampeonatoResponse build(){
        
        CampeonatoResponse response = new CampeonatoResponse();
        response.setId(id);
        response.setNome(nome);
        response.setAno(ano);
        response.setPais(pais);
        return response;
    }
}

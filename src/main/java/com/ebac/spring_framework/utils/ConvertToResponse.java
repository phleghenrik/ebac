package com.ebac.spring_framework.utils;

import com.ebac.spring_framework.builder.FilmeResponseBuilder;
import com.ebac.spring_framework.entities.Filme;
import com.ebac.spring_framework.response.FilmeResponse;

public class ConvertToResponse {

    public static FilmeResponse filmeToResponse(Filme c){
        return FilmeResponseBuilder.create()
                                 .id(c.getIdFilme())
                                 .titulo(c.getTitulo())
                                 .ano(c.getAno())
                                 .build();
    }
}

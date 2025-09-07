package com.ebac.spring_framework.utils;

import com.ebac.spring_framework.builder.CampeonatoResponseBuilder;
import com.ebac.spring_framework.entities.Campeonato;
import com.ebac.spring_framework.response.CampeonatoResponse;

public class ConvertToResponse {

    public static CampeonatoResponse campeonatoToResponse(Campeonato c){
        return
        CampeonatoResponseBuilder.create()
                                 .id(c.getId())
                                 .nome(c.getNome())
                                 .ano(c.getAno())
                                 .pais(c.getPais())
                                 .build();
    }
}

package com.ebac.spring_framework.service;

import com.ebac.spring_framework.entities.Campeonato;
import com.ebac.spring_framework.repository.CampeonatoRepository;
import com.ebac.spring_framework.requests.CampeonatoRequest;
import com.ebac.spring_framework.response.CampeonatoResponse;
import com.ebac.spring_framework.utils.ConvertToResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    private final CampeonatoRepository repository;

    public CampeonatoService(final CampeonatoRepository repository) {
        this.repository = repository;
    }

    public List<CampeonatoResponse> listarTodos() {

        List<Campeonato> campeonatos = repository.findAll();
        List<CampeonatoResponse> response = new ArrayList<>();
        campeonatos.forEach(c -> response.add(ConvertToResponse.campeonatoToResponse(c)));

        return response;
    }

    public void criarCampeonato(CampeonatoRequest request) {

        Campeonato c = new Campeonato();
        c.setNome(request.getNome());
        c.setAno(request.getAno());
        c.setPais(request.getPais());
        repository.save(c);
    }

    public CampeonatoResponse listarPorId(Integer id) throws Exception{
        Optional<Campeonato> campeonato = repository.findById(id);
        return ConvertToResponse.campeonatoToResponse(campeonato.orElseThrow(() -> new Exception("Dado não encontrado.")));

    }

    public void deletarPorId(Integer id) {
        repository.deleteById(id);
    }

    public void deletarTodos() {
        repository.deleteAll();
    }
}

package com.ebac.spring_framework.service;

import com.ebac.spring_framework.entities.Filme;
import com.ebac.spring_framework.repository.FilmeRepository;
import com.ebac.spring_framework.requests.FilmeRequest;
import com.ebac.spring_framework.response.FilmeResponse;
import com.ebac.spring_framework.utils.ConvertToResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(final FilmeRepository repository) {
        this.repository = repository;
    }

    public List<FilmeResponse> listarTodos() {

        List<Filme> campeonatos = repository.findAll();
        List<FilmeResponse> response = new ArrayList<>();
        campeonatos.forEach(c -> response.add(ConvertToResponse.filmeToResponse(c)));

        return response;
    }

    public void criarFilme(FilmeRequest request) {
        Filme c = new Filme();
        c.setTitulo(request.getTitulo());
        c.setAno(request.getAno());
        repository.save(c);
    }

    public FilmeResponse listarPorId(Integer id) throws Exception{
        Optional<Filme> filme = repository.findById(id);
        return ConvertToResponse.filmeToResponse(filme.orElseThrow(() -> new Exception("Filme não encontrado.")));

    }

    public void deletarPorId(Integer id) {
        repository.deleteById(id);
    }

    public void deletarTodos() {
        repository.deleteAll();
    }
}

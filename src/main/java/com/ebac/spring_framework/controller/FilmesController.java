package com.ebac.spring_framework.controller;

import com.ebac.spring_framework.requests.FilmeRequest;
import com.ebac.spring_framework.response.FilmeResponse;
import com.ebac.spring_framework.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/filmes")
public class FilmesController {

     private FilmeService service;

    public FilmesController(final FilmeService service) {
        this.service = service;
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<FilmeResponse>> listarTodos() {
        List<FilmeResponse> campeonatos = service.listarTodos();
        return ResponseEntity.ok(campeonatos);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criar(@RequestBody FilmeRequest request) {
        service.criarFilme(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listarId(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(service.listarPorId(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dado não encontrado.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarId(@PathVariable Integer id) {

        service.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/deletar-todos")
    public ResponseEntity<Void> deletarTodos() {

        service.deletarTodos();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

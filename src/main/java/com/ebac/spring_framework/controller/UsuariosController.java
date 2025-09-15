package com.ebac.spring_framework.controller;

import com.ebac.spring_framework.requests.FilmeRequest;
import com.ebac.spring_framework.requests.UsuarioRequest;
import com.ebac.spring_framework.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuariosController {

    private final UsuarioService service;

    public UsuariosController(final UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criar(@RequestBody UsuarioRequest request) {
        service.criarUsuario(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarId(@PathVariable String id) {
        service.deletarUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

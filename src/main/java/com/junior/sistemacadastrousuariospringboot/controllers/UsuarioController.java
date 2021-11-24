package com.junior.sistemacadastrousuariospringboot.controllers;

import java.util.List;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;
import com.junior.sistemacadastrousuariospringboot.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        usuario = usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }
    
}

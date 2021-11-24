package com.junior.sistemacadastrousuariospringboot.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.junior.sistemacadastrousuariospringboot.dto.UsuarioDTO;
import com.junior.sistemacadastrousuariospringboot.entities.Usuario;
import com.junior.sistemacadastrousuariospringboot.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(usuario -> new UsuarioDTO(usuario))
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(usuariosDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario novoUsuario){
        novoUsuario = usuarioService.update(id, novoUsuario);
        return ResponseEntity.ok().body(novoUsuario);
    }
    
}

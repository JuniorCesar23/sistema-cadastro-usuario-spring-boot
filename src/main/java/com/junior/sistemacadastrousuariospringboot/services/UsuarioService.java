package com.junior.sistemacadastrousuariospringboot.services;

import java.util.List;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;
import com.junior.sistemacadastrousuariospringboot.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    
}

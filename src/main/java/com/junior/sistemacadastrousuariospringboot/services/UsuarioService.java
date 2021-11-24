package com.junior.sistemacadastrousuariospringboot.services;

import java.util.List;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;
import com.junior.sistemacadastrousuariospringboot.repository.UsuarioRepository;
import com.junior.sistemacadastrousuariospringboot.services.exceptions.EmailExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // ADICIONAR USUÁRIO
    public Usuario save(Usuario usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new EmailExistsException(usuario.getEmail());
        }
        return usuarioRepository.save(usuario);
    }

    // LISTAR TODOS OS USUÁRIOS CADASTRADOS
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    
}

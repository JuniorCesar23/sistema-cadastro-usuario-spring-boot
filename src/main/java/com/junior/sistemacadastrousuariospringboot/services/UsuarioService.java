package com.junior.sistemacadastrousuariospringboot.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;
import com.junior.sistemacadastrousuariospringboot.repository.UsuarioRepository;
import com.junior.sistemacadastrousuariospringboot.services.exceptions.EmailExistsException;
import com.junior.sistemacadastrousuariospringboot.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    // MOSTRAR POR ID
    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // DELETAR USUÁRIO
    public void deleteById(Long id){
        try {
            usuarioRepository.deleteById(id);
        } catch (ResourceNotFoundException | EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // ATUALIZAR USUÁRIO
    public Usuario update(Long id, Usuario novoUsuario){
        try {
            Usuario usuario = usuarioRepository.getOne(id);
            atualizarDados(usuario, novoUsuario);
            return usuarioRepository.save(usuario); 
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void atualizarDados(Usuario usuario, Usuario novoUsuario) {
        usuario.setNomeCompleto(novoUsuario.getNomeCompleto());
        usuario.setIdade(novoUsuario.getIdade());
        usuario.setEmail(novoUsuario.getEmail());
    }
    
}

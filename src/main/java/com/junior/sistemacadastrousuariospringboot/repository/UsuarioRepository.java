package com.junior.sistemacadastrousuariospringboot.repository;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

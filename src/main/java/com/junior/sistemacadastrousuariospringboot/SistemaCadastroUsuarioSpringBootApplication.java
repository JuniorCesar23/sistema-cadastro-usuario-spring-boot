package com.junior.sistemacadastrousuariospringboot;

import java.util.Arrays;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;
import com.junior.sistemacadastrousuariospringboot.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaCadastroUsuarioSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemaCadastroUsuarioSpringBootApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Júnior César", 20, "juniorcesar@gmail.com");
		Usuario u2 = new Usuario(null, "Lara Kaliny", 12, "kaliny@gmail.com");
		Usuario u3 = new Usuario(null, "Luiz Davi", 02, "davi@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

	}

}

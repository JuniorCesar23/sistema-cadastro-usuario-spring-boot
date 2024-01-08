package com.junior.sistemacadastrousuariospringboot;

import java.util.Arrays;

import com.junior.sistemacadastrousuariospringboot.entities.User;
import com.junior.sistemacadastrousuariospringboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserRegistrationSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationSystemApplication.class, args);
	}

	@Autowired
	private UserRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Júnior César", 20, "juniorcesar@gmail.com");
		User u2 = new User(null, "Lara Kaliny", 12, "kaliny@gmail.com");
		User u3 = new User(null, "Luiz Davi", 02, "davi@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

	}

}

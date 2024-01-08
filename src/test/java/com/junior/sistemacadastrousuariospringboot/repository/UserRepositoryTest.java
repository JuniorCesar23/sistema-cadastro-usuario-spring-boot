package com.junior.sistemacadastrousuariospringboot.repository;

import com.junior.sistemacadastrousuariospringboot.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    void saveData(){
        User user = new User(1L, "Júnior", 22, "junior@gmail.com");
        userRepository.save(user);
    }

    @Test
    void testExistByEmail(){
        Assertions.assertTrue(userRepository.existsByEmail("junior@gmail.com"));
    }

}

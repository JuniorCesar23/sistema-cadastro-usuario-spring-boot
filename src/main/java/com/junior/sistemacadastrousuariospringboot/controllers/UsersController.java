package com.junior.sistemacadastrousuariospringboot.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.junior.sistemacadastrousuariospringboot.dto.UserDto;
import com.junior.sistemacadastrousuariospringboot.entities.User;
import com.junior.sistemacadastrousuariospringboot.services.UserService;

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
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        user = userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> users = userService.findAll();
        List<UserDto> usersDTO = users.stream().map(user -> new UserDto(user))
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User newUser){
        newUser = userService.update(id, newUser);
        return ResponseEntity.ok().body(newUser);
    }
    
}

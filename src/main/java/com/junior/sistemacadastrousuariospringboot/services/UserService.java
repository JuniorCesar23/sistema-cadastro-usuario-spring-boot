package com.junior.sistemacadastrousuariospringboot.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.junior.sistemacadastrousuariospringboot.entities.User;
import com.junior.sistemacadastrousuariospringboot.repository.UserRepository;
import com.junior.sistemacadastrousuariospringboot.services.exceptions.EmailExistsException;
import com.junior.sistemacadastrousuariospringboot.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User usuario){
        if (userRepository.existsByEmail(usuario.getEmail())){
            throw new EmailExistsException(usuario.getEmail());
        }
        return userRepository.save(usuario);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id){
        try {
            userRepository.deleteById(id);
        } catch (ResourceNotFoundException | EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public User update(Long id, User newUser){
        try {
            User user = userRepository.getOne(id);
            updateData(user, newUser);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(User user, User newUser) {
        user.setUsername(newUser.getUsername());
        user.setYear(newUser.getYear());
        user.setEmail(newUser.getEmail());
    }
    
}

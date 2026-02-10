package com.gprec.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gprec.demo.model.User;
import com.gprec.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createUser(String username, String password){

         if (repository.existsByUsername(username)) {
        throw new RuntimeException("USERNAME_EXISTS");
       }
        User user = new User(username, password);
        return repository.save(user);
    }
    
public List<User> getAllUsers() {
    return repository.findAll();
}
}

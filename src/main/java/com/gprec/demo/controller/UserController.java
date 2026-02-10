package com.gprec.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gprec.demo.model.User;
import com.gprec.demo.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin(origins = "*")

public class UserController {
    @Autowired
    private UserService service;
@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody UserRegisterRequest body) {

    try {
        User user = service.createUser(
            body.getUsername(),
            body.getPassword()
        );
        return ResponseEntity.ok(user);

    } catch (RuntimeException e) {
        if (e.getMessage().equals("USERNAME_EXISTS")) {
            return ResponseEntity
                    .badRequest()
                    .body("This username is already registered. Try another.");
        }
        return ResponseEntity.internalServerError().build();
    }
}

   
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class UserRegisterRequest {
    private String username;
    private String password;
}
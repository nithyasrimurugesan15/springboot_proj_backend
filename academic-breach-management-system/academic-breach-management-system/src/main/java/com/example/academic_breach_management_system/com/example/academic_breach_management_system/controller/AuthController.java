package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.User;
import com.example.academic_breach_management_system.service.BreachDetectionService;
import com.example.academic_breach_management_system.service.UserService;
import com.example.academic_breach_management_system.dto.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BreachDetectionService breachDetectionService;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    // LOGIN
    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user){

        Optional<User> existingUser =
                userService.login(user.getEmail(), user.getPassword());

        if(existingUser.isPresent()){

            User u = existingUser.get();

            return new LoginResponse(
                    u.getId(),
                    u.getName(),
                    u.getEmail(),
                    u.getRole()
            );
        }

        breachDetectionService.detectMultipleLoginFailures(user.getEmail());

        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Invalid Credentials"
        );
    }
}
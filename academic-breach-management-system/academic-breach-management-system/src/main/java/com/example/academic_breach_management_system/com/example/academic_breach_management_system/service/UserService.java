package com.example.academic_breach_management_system.service;

import com.example.academic_breach_management_system.entity.User;
import com.example.academic_breach_management_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

//    public Optional<User> login(String email,String password){
//
//        Optional<User> user = userRepository.findByEmail(email);
//
//        if(user.isPresent() && user.get().getPassword().equals(password)){
//            return user;
//        }
//
//        return Optional.empty();
//    }

    public Optional<User> login(String email,String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

}
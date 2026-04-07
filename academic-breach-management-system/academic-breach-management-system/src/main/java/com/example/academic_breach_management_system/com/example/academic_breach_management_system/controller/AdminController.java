package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.Student;
import com.example.academic_breach_management_system.entity.User;
import com.example.academic_breach_management_system.repository.StudentRepository;
import com.example.academic_breach_management_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
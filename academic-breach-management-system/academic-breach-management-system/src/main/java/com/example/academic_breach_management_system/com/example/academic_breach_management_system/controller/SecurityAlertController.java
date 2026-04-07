package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.SecurityAlert;
import com.example.academic_breach_management_system.repository.SecurityAlertRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/securityAlerts")
@CrossOrigin(origins = "http://localhost:5174")
public class SecurityAlertController {

    @Autowired
    private SecurityAlertRepository alertRepository;

    @GetMapping
    public List<SecurityAlert> getLogs(){
        return alertRepository.findAll();
    }
}
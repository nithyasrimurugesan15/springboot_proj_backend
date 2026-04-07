package com.example.academic_breach_management_system.service;

import com.example.academic_breach_management_system.entity.SecurityAlert;
import com.example.academic_breach_management_system.repository.SecurityAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BreachDetectionService {

    @Autowired
    private SecurityAlertRepository alertRepository;

    public void detectMultipleLoginFailures(String email){

        SecurityAlert alert = new SecurityAlert();

        alert.setAlertType("LOGIN_FAILURE");
        alert.setDescription("Multiple failed login attempts detected for " + email);
        alert.setSeverity("HIGH");
        alert.setCreatedAt(LocalDateTime.now());

        alertRepository.save(alert);
    }
}
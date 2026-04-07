package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.ActivityLog;
import com.example.academic_breach_management_system.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin
public class SecurityController {

    @Autowired
    private ActivityLogRepository logRepository;

    @GetMapping
    public List<ActivityLog> getLogs() {
        return logRepository.findAll();
    }
}
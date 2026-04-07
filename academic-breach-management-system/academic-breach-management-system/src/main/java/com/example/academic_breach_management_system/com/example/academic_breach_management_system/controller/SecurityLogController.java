package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.SecurityLog;
import com.example.academic_breach_management_system.repository.SecurityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/securityLogs")
@CrossOrigin(origins = "*")
public class SecurityLogController {

    @Autowired
    private SecurityLogRepository securityLogRepository;

    @GetMapping
    public List<SecurityLog> getSecurityLogs() {
        return securityLogRepository.findAll();
    }
}

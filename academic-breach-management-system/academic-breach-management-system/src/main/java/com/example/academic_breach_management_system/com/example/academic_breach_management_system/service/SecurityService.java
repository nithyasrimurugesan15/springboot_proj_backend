package com.example.academic_breach_management_system.service;

import com.example.academic_breach_management_system.entity.ActivityLog;
import com.example.academic_breach_management_system.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private ActivityLogRepository logRepository;

    public void logActivity(ActivityLog log) {
        logRepository.save(log);
    }

}
package com.example.academic_breach_management_system.repository;

import com.example.academic_breach_management_system.entity.SecurityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityLogRepository extends JpaRepository<SecurityLog, Long> {
}

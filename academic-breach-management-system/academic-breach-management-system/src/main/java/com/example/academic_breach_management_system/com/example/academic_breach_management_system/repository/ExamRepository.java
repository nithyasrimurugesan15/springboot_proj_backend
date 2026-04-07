package com.example.academic_breach_management_system.repository;

import com.example.academic_breach_management_system.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
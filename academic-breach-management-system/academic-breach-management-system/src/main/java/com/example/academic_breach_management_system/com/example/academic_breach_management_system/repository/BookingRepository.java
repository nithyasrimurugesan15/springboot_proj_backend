package com.example.academic_breach_management_system.repository;

import com.example.academic_breach_management_system.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByRollNumberAndExamId(String rollNumber, Long examId);

    List<Booking> findByTeacherIdAndStatus(Long teacherId, String status);
}
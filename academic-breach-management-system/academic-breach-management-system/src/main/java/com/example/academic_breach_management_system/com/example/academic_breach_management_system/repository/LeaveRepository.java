package com.example.academic_breach_management_system.repository;

import com.example.academic_breach_management_system.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByRollNumber(String rollNumber);

    List<LeaveRequest> findByStatus(String status);
}
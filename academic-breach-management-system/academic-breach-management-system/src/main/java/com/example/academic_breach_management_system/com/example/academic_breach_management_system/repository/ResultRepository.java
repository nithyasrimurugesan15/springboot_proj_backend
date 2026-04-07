package com.example.academic_breach_management_system.repository;

import com.example.academic_breach_management_system.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findBySemester(int semester);

}
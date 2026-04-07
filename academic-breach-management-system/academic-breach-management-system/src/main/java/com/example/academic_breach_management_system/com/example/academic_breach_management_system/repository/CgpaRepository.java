package com.example.academic_breach_management_system.repository;

import com.example.academic_breach_management_system.entity.CgpaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CgpaRepository extends JpaRepository<CgpaRecord,Long> {

    List<CgpaRecord> findByEmail(String email);
}
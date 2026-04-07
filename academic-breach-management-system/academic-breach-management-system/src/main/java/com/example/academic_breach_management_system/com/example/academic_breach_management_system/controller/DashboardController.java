package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.CgpaRecord;
import com.example.academic_breach_management_system.repository.CgpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    @Autowired
    private CgpaRepository cgpaRepository;

    @GetMapping("/cgpa/{email}")
    public Map<String,Object> getCgpa(@PathVariable String email){

        List<CgpaRecord> records = cgpaRepository.findByEmail(email);

        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for(CgpaRecord r : records){
            labels.add(r.getSemester());
            data.add(r.getCgpa());
        }

        Map<String,Object> response = new HashMap<>();
        response.put("labels",labels);
        response.put("data",data);

        return response;
    }
}
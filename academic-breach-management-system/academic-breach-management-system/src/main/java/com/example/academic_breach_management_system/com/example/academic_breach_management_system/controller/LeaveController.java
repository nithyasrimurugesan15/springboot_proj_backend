package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.LeaveRequest;
import com.example.academic_breach_management_system.repository.LeaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @PostMapping("/leave")
    public Map<String, String> applyLeave(@RequestBody LeaveRequest leave){

        leave.setStatus("PENDING");

        leaveRepository.save(leave);

        Map<String,String> response = new HashMap<>();
        response.put("message","Leave applied successfully");

        return response;
    }

    @GetMapping("/leaves/{rollNumber}")
    public List<LeaveRequest> getLeaves(@PathVariable String rollNumber){

        return leaveRepository.findByRollNumber(rollNumber);

    }
}
package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public String bookExam(@RequestBody Map<String,Object> data){

        String rollNumber = data.get("rollNumber").toString();
        Long examId = Long.valueOf(data.get("examId").toString());

        bookingService.bookExam(rollNumber, examId);

        return "Exam booked successfully";
    }
}

package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.Booking;
import com.example.academic_breach_management_system.entity.Exam;
import com.example.academic_breach_management_system.repository.BookingRepository;
import com.example.academic_breach_management_system.repository.ExamRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5174")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/exams")
    public List<Exam> getExams(){
        return examRepository.findAll();
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    @PostMapping("/bookExam")
    public Map<String, String> bookExam(@RequestBody Map<String, Object> payload){

        String rollNumber = (String) payload.get("rollNumber");
        Long examId = Long.valueOf(payload.get("examId").toString());

        Exam exam = examRepository.findById(examId).orElseThrow();

        if(exam.getSlots() <= 0){
            throw new RuntimeException("No slots available");
        }

        Booking booking = new Booking();
        booking.setRollNumber(rollNumber);
        booking.setExamId(examId);
        booking.setBookingDate(LocalDateTime.now());

        bookingRepository.save(booking);

        // reduce slot
        exam.setSlots(exam.getSlots() - 1);
        examRepository.save(exam);

        Map<String,String> response = new HashMap<>();
        response.put("message","Exam booked successfully");

        return response;
    }
}
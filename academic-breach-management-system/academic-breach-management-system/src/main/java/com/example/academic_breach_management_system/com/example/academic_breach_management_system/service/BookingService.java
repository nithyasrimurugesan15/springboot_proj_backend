package com.example.academic_breach_management_system.service;

import com.example.academic_breach_management_system.entity.Booking;
import com.example.academic_breach_management_system.entity.Exam;
import com.example.academic_breach_management_system.repository.BookingRepository;
import com.example.academic_breach_management_system.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ExamRepository examRepository;

    public void bookExam(String rollNumber, Long examId){

        if(bookingRepository.existsByRollNumberAndExamId(rollNumber, examId)){
            throw new RuntimeException("Exam already booked");
        }

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        if(exam.getSlots() <= 0){
            throw new RuntimeException("No slots available");
        }

        Booking booking = new Booking();
        booking.setRollNumber(rollNumber);
        booking.setExamId(examId);
        booking.setBookingDate(LocalDateTime.now());

        bookingRepository.save(booking);

        exam.setSlots(exam.getSlots() - 1);
        examRepository.save(exam);
    }
}
package com.example.academic_breach_management_system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "exam_id")
    private Long examId;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "status")
    private String status = "PENDING";

    @Column(name = "teacher_id")
    private Long teacherId;

    public Booking(){}

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getRollNumber(){ return rollNumber; }
    public void setRollNumber(String rollNumber){ this.rollNumber = rollNumber; }

    public Long getExamId(){ return examId; }
    public void setExamId(Long examId){ this.examId = examId; }

    public LocalDateTime getBookingDate(){ return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate){ this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
}
package com.example.academic_breach_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String date;
    private String time;
    private String room;

    private int slots;
    private double fees;

    public Exam(){}

    public Long getId(){ return id; }

    public String getSubject(){ return subject; }
    public void setSubject(String subject){ this.subject = subject; }

    public String getDate(){ return date; }
    public void setDate(String date){ this.date = date; }

    public String getTime(){ return time; }
    public void setTime(String time){ this.time = time; }

    public String getRoom(){ return room; }
    public void setRoom(String room){ this.room = room; }

    public int getSlots(){ return slots; }
    public void setSlots(int slots){ this.slots = slots; }

    public double getFees(){ return fees; }
    public void setFees(double fees){ this.fees = fees; }
}
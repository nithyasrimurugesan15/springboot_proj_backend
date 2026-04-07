package com.example.academic_breach_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private int internalMarks;
    private int externalMarks;
    private String grade;
    private String status;
    private int semester;

    public Result(){}

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getInternalMarks() {
        return internalMarks;
    }

    public int getExternalMarks() {
        return externalMarks;
    }

    public String getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public int getSemester() {
        return semester;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setInternalMarks(int internalMarks) {
        this.internalMarks = internalMarks;
    }

    public void setExternalMarks(int externalMarks) {
        this.externalMarks = externalMarks;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
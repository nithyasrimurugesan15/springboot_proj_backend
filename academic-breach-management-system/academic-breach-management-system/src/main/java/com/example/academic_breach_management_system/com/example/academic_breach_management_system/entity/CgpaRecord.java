package com.example.academic_breach_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cgpa_records")
public class CgpaRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String semester;
    private Double cgpa;

    public Long getId(){ return id; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }

    public String getSemester(){ return semester; }
    public void setSemester(String semester){ this.semester=semester; }

    public Double getCgpa(){ return cgpa; }
    public void setCgpa(Double cgpa){ this.cgpa=cgpa; }
}
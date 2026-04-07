package com.example.academic_breach_management_system.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "security_alerts")
public class SecurityAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertType;

    private String description;

    private String severity;

    private LocalDateTime createdAt;

    public SecurityAlert(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getAlertType(){
        return alertType;
    }

    public void setAlertType(String alertType){
        this.alertType = alertType;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getSeverity(){
        return severity;
    }

    public void setSeverity(String severity){
        this.severity = severity;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}
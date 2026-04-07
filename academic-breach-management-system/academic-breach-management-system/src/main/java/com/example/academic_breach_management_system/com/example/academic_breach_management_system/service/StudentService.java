package com.example.academic_breach_management_system.service;

import com.example.academic_breach_management_system.entity.Student;
import com.example.academic_breach_management_system.entity.ActivityLog;
import com.example.academic_breach_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SecurityService securityService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {

        Student saved = studentRepository.save(student);

        ActivityLog log = new ActivityLog();
        log.setAction("Student record modified: " + student.getName());
        log.setTimestamp(java.time.LocalDateTime.now());

        securityService.logActivity(log);

        return saved;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
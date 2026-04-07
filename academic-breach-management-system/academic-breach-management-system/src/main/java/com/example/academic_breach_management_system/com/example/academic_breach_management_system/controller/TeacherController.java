package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.Booking;
import com.example.academic_breach_management_system.entity.Course;
import com.example.academic_breach_management_system.entity.LeaveRequest;
import com.example.academic_breach_management_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin(origins = "http://localhost:5173")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // --- LEAVE REQUESTS ---
    @GetMapping("/leave-requests/pending")
    public List<LeaveRequest> getPendingLeaves(){
        return teacherService.getPendingLeaves();
    }

    @PutMapping("/leave-requests/{id}/approve")
    public LeaveRequest approveLeave(@PathVariable Long id){
        return teacherService.updateLeaveStatus(id, "APPROVED");
    }

    @PutMapping("/leave-requests/{id}/reject")
    public LeaveRequest rejectLeave(@PathVariable Long id){
        return teacherService.updateLeaveStatus(id, "REJECTED");
    }

    @PutMapping("/leave-requests/{id}/status")
    public LeaveRequest updateLeaveStatus(@PathVariable Long id, @RequestBody Map<String, String> payload){
        return teacherService.updateLeaveStatus(id, payload.get("status"));
    }

    // --- COURSES ---
    @GetMapping("/courses/teacher/{teacherId}")
    public List<Course> getCourses(@PathVariable Long teacherId){
        return teacherService.getCoursesByTeacher(teacherId);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return teacherService.addCourse(course);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course){
        return teacherService.updateCourse(id, course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){
        teacherService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    // --- SLOTS (BOOKINGS) ---
    @GetMapping("/slots/teacher/{teacherId}/pending")
    public List<Booking> getPendingSlots(@PathVariable Long teacherId){
        return teacherService.getPendingSlots(teacherId);
    }

    @PutMapping("/slots/{id}/status")
    public Booking updateSlotStatus(@PathVariable Long id, @RequestBody Map<String, String> payload){
        return teacherService.updateSlotStatus(id, payload.get("status"));
    }
}

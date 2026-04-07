package com.example.academic_breach_management_system.service;

import com.example.academic_breach_management_system.entity.Booking;
import com.example.academic_breach_management_system.entity.Course;
import com.example.academic_breach_management_system.entity.LeaveRequest;
import com.example.academic_breach_management_system.repository.BookingRepository;
import com.example.academic_breach_management_system.repository.CourseRepository;
import com.example.academic_breach_management_system.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private LeaveRepository leaveRepository;
    
    @Autowired
    private BookingRepository bookingRepository;

    // Courses
    public List<Course> getCoursesByTeacher(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }
    
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public Course updateCourse(Long id, Course details) {
        Optional<Course> opt = courseRepository.findById(id);
        if(opt.isPresent()){
            Course existing = opt.get();
            existing.setName(details.getName());
            existing.setCode(details.getCode());
            existing.setTeacherId(details.getTeacherId());
            return courseRepository.save(existing);
        }
        return null;
    }
    
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Leave Requests
    public List<LeaveRequest> getPendingLeaves() {
        return leaveRepository.findByStatus("PENDING");
    }
    
    public LeaveRequest updateLeaveStatus(Long id, String status) {
        Optional<LeaveRequest> opt = leaveRepository.findById(id);
        if(opt.isPresent()){
            LeaveRequest lr = opt.get();
            lr.setStatus(status);
            return leaveRepository.save(lr);
        }
        return null;
    }

    // Slots
    public List<Booking> getPendingSlots(Long teacherId) {
        return bookingRepository.findByTeacherIdAndStatus(teacherId, "PENDING");
    }
    
    public Booking updateSlotStatus(Long id, String status) {
        Optional<Booking> opt = bookingRepository.findById(id);
        if(opt.isPresent()) {
            Booking b = opt.get();
            b.setStatus(status);
            return bookingRepository.save(b);
        }
        return null;
    }
}

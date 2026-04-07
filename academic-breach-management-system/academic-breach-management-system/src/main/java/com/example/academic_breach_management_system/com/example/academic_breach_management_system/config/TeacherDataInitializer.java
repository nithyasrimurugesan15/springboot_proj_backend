package com.example.academic_breach_management_system.config;

import com.example.academic_breach_management_system.entity.Booking;
import com.example.academic_breach_management_system.entity.Course;
import com.example.academic_breach_management_system.entity.LeaveRequest;
import com.example.academic_breach_management_system.repository.BookingRepository;
import com.example.academic_breach_management_system.repository.CourseRepository;
import com.example.academic_breach_management_system.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class TeacherDataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize Courses
        if (courseRepository.count() == 0) {
            Course c1 = new Course();
            c1.setName("Data Structures");
            c1.setCode("CS201");
            c1.setTeacherId(1L);

            Course c2 = new Course();
            c2.setName("Web Development");
            c2.setCode("CS301");
            c2.setTeacherId(1L);

            courseRepository.save(c1);
            courseRepository.save(c2);
        }

        // Initialize Leave Requests (ensure at least one PENDING)
        if (leaveRepository.count() == 0) {
            LeaveRequest lr1 = new LeaveRequest();
            lr1.setRollNumber("101");
            lr1.setReason("Medical Leave");
            lr1.setLeaveDate("2026-04-10");
            lr1.setStatus("PENDING");
            
            leaveRepository.save(lr1);
        }

        // Initialize Bookings (ensure at least one PENDING for Teacher 1)
        if (bookingRepository.count() == 0) {
            Booking b1 = new Booking();
            b1.setRollNumber("102");
            b1.setExamId(1L);
            b1.setBookingDate(LocalDateTime.now().plusDays(2));
            b1.setStatus("PENDING");
            b1.setTeacherId(1L);

            bookingRepository.save(b1);
        }
    }
}

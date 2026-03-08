package com.learning.cms.controller;

import com.learning.cms.dto.enrollment.EnrollmentRequestDTO;
import com.learning.cms.dto.enrollment.EnrollmentResponseDTO;
import com.learning.cms.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public EnrollmentResponseDTO enrollStudent(@RequestBody EnrollmentRequestDTO request) {
        return enrollmentService.enrollStudent(request);
    }

    @GetMapping("/student/{studentId}")
    public List<EnrollmentResponseDTO> getStudentEnrollments(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<EnrollmentResponseDTO> getCourseEnrollments(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }
}
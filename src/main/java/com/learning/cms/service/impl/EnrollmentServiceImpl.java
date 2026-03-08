package com.learning.cms.service.impl;

import com.learning.cms.dto.enrollment.EnrollmentRequestDTO;
import com.learning.cms.dto.enrollment.EnrollmentResponseDTO;
import com.learning.cms.entity.Course;
import com.learning.cms.entity.Enrollment;
import com.learning.cms.entity.EnrollmentStatus;
import com.learning.cms.entity.User;
import com.learning.cms.repository.CourseRepository;
import com.learning.cms.repository.EnrollmentRepository;
import com.learning.cms.repository.UserRepository;
import com.learning.cms.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 UserRepository userRepository,
                                 CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public EnrollmentResponseDTO enrollStudent(EnrollmentRequestDTO request) {

        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus(EnrollmentStatus.ACTIVE);
        enrollment.setProgressPercentage(0);

        Enrollment saved = enrollmentRepository.save(enrollment);

        return mapToResponse(saved);
    }

    @Override
    public List<EnrollmentResponseDTO> getEnrollmentsByStudent(Long studentId) {

        return enrollmentRepository.findByStudentId(studentId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentResponseDTO> getEnrollmentsByCourse(Long courseId) {

        return enrollmentRepository.findByCourseId(courseId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private EnrollmentResponseDTO mapToResponse(Enrollment enrollment) {

        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();

        dto.setId(enrollment.getId());
        dto.setCourseTitle(enrollment.getCourse().getTitle());
        dto.setStudentName(enrollment.getStudent().getFullName());
        dto.setStatus(enrollment.getStatus());
        dto.setProgressPercentage(enrollment.getProgressPercentage());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());

        return dto;
    }
}
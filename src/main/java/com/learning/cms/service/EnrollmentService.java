package com.learning.cms.service;

import com.learning.cms.dto.enrollment.EnrollmentRequestDTO;
import com.learning.cms.dto.enrollment.EnrollmentResponseDTO;

import java.util.List;

public interface EnrollmentService {

    EnrollmentResponseDTO enrollStudent(EnrollmentRequestDTO request);

    List<EnrollmentResponseDTO> getEnrollmentsByStudent(Long studentId);

    List<EnrollmentResponseDTO> getEnrollmentsByCourse(Long courseId);
}
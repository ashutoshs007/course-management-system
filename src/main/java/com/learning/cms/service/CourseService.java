package com.learning.cms.service;

import com.learning.cms.dto.course.CourseRequestDTO;
import com.learning.cms.dto.course.CourseResponseDTO;
import org.springframework.data.domain.Page;

public interface CourseService {

    CourseResponseDTO createCourse(Long instructorId, CourseRequestDTO request);

    CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO request);

    void deleteCourse(Long courseId);

    Page<CourseResponseDTO> getAllCourses(int page, int size, String sort);

    CourseResponseDTO getCourseById(Long id);
}
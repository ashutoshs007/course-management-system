package com.learning.cms.service.impl;

import com.learning.cms.dto.course.CourseRequestDTO;
import com.learning.cms.dto.course.CourseResponseDTO;
import com.learning.cms.entity.Course;
import com.learning.cms.entity.User;
import com.learning.cms.repository.CourseRepository;
import com.learning.cms.repository.UserRepository;
import com.learning.cms.service.CourseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(CourseRepository courseRepository,
                             UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CourseResponseDTO createCourse(Long instructorId, CourseRequestDTO request) {

        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        Course course = new Course();

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setDuration(request.getDuration());
        course.setLevel(request.getLevel());
        course.setInstructor(instructor);

        Course savedCourse = courseRepository.save(course);

        return convertToDTO(savedCourse);
    }

    @Override
    public CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO request) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setDuration(request.getDuration());
        course.setLevel(request.getLevel());

        Course updatedCourse = courseRepository.save(course);

        return convertToDTO(updatedCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        courseRepository.delete(course);
    }

    @Override
    public Page<CourseResponseDTO> getAllCourses(int page, int size, String sort) {

        Page<Course> coursePage = courseRepository.findAll(
                PageRequest.of(page, size, Sort.by(sort))
        );

        return coursePage.map(this::convertToDTO);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return convertToDTO(course);
    }

    private CourseResponseDTO convertToDTO(Course course) {

        CourseResponseDTO dto = new CourseResponseDTO();

        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setPrice(course.getPrice());
        dto.setDuration(course.getDuration());
        dto.setLevel(course.getLevel());
        dto.setInstructorName(course.getInstructor().getFullName());
        dto.setCreatedAt(course.getCreatedAt());

        return dto;
    }
}
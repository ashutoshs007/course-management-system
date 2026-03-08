package com.learning.cms.controller;

import com.learning.cms.dto.course.CourseRequestDTO;
import com.learning.cms.dto.course.CourseResponseDTO;
import com.learning.cms.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/{instructorId}")
    public CourseResponseDTO createCourse(@PathVariable Long instructorId,
                                          @RequestBody CourseRequestDTO request) {
        return courseService.createCourse(instructorId, request);
    }

    @GetMapping
    public Page<CourseResponseDTO> getCourses(@RequestParam int page,
                                              @RequestParam int size,
                                              @RequestParam String sort) {
        return courseService.getAllCourses(page, size, sort);
    }

    @GetMapping("/{id}")
    public CourseResponseDTO getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
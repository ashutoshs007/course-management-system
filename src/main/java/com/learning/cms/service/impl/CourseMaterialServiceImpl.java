package com.learning.cms.service.impl;

import com.learning.cms.dto.material.MaterialResponseDTO;
import com.learning.cms.dto.material.MaterialUploadDTO;
import com.learning.cms.entity.Course;
import com.learning.cms.entity.CourseMaterial;
import com.learning.cms.repository.CourseMaterialRepository;
import com.learning.cms.repository.CourseRepository;
import com.learning.cms.service.CourseMaterialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {

    private final CourseMaterialRepository materialRepository;
    private final CourseRepository courseRepository;

    public CourseMaterialServiceImpl(CourseMaterialRepository materialRepository,
                                     CourseRepository courseRepository) {
        this.materialRepository = materialRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public MaterialResponseDTO uploadMaterial(MaterialUploadDTO request) {

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        CourseMaterial material = new CourseMaterial();

        material.setTitle(request.getTitle());
        material.setFileName(request.getFile().getOriginalFilename());
        material.setFileType(request.getFile().getContentType());
        material.setFileUrl("/uploads/" + request.getFile().getOriginalFilename());
        material.setCourse(course);

        CourseMaterial saved = materialRepository.save(material);

        return mapToResponse(saved);
    }

    @Override
    public List<MaterialResponseDTO> getMaterialsByCourse(Long courseId) {

        return materialRepository.findByCourseId(courseId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private MaterialResponseDTO mapToResponse(CourseMaterial material) {

        MaterialResponseDTO dto = new MaterialResponseDTO();

        dto.setId(material.getId());
        dto.setTitle(material.getTitle());
        dto.setFileName(material.getFileName());
        dto.setFileType(material.getFileType());
        dto.setFileUrl(material.getFileUrl());
        dto.setUploadDate(material.getUploadDate());

        return dto;
    }
}
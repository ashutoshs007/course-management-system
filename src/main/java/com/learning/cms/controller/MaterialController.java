package com.learning.cms.controller;

import com.learning.cms.dto.material.MaterialResponseDTO;
import com.learning.cms.dto.material.MaterialUploadDTO;
import com.learning.cms.service.CourseMaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final CourseMaterialService materialService;

    public MaterialController(CourseMaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/upload")
    public MaterialResponseDTO uploadMaterial(MaterialUploadDTO request) {
        return materialService.uploadMaterial(request);
    }

    @GetMapping("/course/{courseId}")
    public List<MaterialResponseDTO> getMaterials(@PathVariable Long courseId) {
        return materialService.getMaterialsByCourse(courseId);
    }
}
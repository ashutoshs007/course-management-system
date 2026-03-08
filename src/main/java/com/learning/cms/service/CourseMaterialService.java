package com.learning.cms.service;

import com.learning.cms.dto.material.MaterialResponseDTO;
import com.learning.cms.dto.material.MaterialUploadDTO;

import java.util.List;

public interface CourseMaterialService {

    MaterialResponseDTO uploadMaterial(MaterialUploadDTO request);

    List<MaterialResponseDTO> getMaterialsByCourse(Long courseId);
}
package com.learning.cms.dto.material;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MaterialResponseDTO {

    private Long id;

    private String title;

    private String fileName;

    private String fileType;

    private String fileUrl;

    private LocalDateTime uploadDate;

}
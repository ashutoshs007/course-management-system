package com.learning.cms.dto.enrollment;

import com.learning.cms.entity.EnrollmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EnrollmentResponseDTO {

    private Long id;

    private String courseTitle;

    private String studentName;

    private EnrollmentStatus status;

    private int progressPercentage;

    private LocalDateTime enrollmentDate;

}
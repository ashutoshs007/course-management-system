package com.learning.cms.dto.enrollment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentRequestDTO {

    private Long courseId;
    private Long studentId;
}
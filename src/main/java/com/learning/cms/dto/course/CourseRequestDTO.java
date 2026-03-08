package com.learning.cms.dto.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDTO {

    private String title;
    private String description;
    private double price;
    private String duration;
    private String level;
}
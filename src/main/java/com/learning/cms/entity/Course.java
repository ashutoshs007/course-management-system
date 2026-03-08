package com.learning.cms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double price;
    private String duration;
    private String level;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="instructor_id")
    private User instructor;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
    }
}
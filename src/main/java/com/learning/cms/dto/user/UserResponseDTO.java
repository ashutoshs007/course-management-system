package com.learning.cms.dto.user;

import com.learning.cms.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;

    private String fullName;

    private String email;

    private Role role;

    private String profilePicture;

    private LocalDateTime createdAt;
}
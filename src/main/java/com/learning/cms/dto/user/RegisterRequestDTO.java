package com.learning.cms.dto.user;

import com.learning.cms.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    private String fullName;
    private String email;
    private String password;
    private Role role;
}
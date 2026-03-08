package com.learning.cms.service;

import com.learning.cms.dto.user.LoginRequestDTO;
import com.learning.cms.dto.user.RegisterRequestDTO;
import com.learning.cms.dto.user.UserResponseDTO;

public interface UserService {

    UserResponseDTO registerUser(RegisterRequestDTO request);

    UserResponseDTO loginUser(LoginRequestDTO request);

    UserResponseDTO getUserById(Long id);
}
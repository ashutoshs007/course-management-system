package com.learning.cms.controller;

import com.learning.cms.dto.user.LoginRequestDTO;
import com.learning.cms.dto.user.RegisterRequestDTO;
import com.learning.cms.dto.user.UserResponseDTO;
import com.learning.cms.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody RegisterRequestDTO request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody LoginRequestDTO request) {
        return userService.loginUser(request);
    }
}
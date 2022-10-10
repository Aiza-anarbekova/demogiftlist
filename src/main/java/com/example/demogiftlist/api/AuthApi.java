package com.example.demogiftlist.api;

import com.example.demogiftlist.dto.AuthRequest;
import com.example.demogiftlist.dto.AuthResponse;
import com.example.demogiftlist.dto.LoginRequest;
import com.example.demogiftlist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt")
@RequiredArgsConstructor
public class AuthApi {
    private final UserService userService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest authRequest) {
        return userService.login(authRequest);
    }


    @PostMapping("/registration")
    public AuthResponse create(@RequestBody AuthRequest request) {
        return userService.createUser(request);
    }
}

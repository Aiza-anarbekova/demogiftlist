package com.example.demogiftlist.dto;

import com.example.demogiftlist.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthResponse {

    private String email;
    private String token;
    private Role role;
}

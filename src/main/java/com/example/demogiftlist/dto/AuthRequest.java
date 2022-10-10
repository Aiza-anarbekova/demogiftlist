package com.example.demogiftlist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

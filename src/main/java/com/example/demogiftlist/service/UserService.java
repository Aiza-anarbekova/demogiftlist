package com.example.demogiftlist.service;

import com.example.demogiftlist.dto.AuthRequest;
import com.example.demogiftlist.dto.AuthResponse;
import com.example.demogiftlist.dto.LoginRequest;
import com.example.demogiftlist.entities.User;
import com.example.demogiftlist.enums.Role;
import com.example.demogiftlist.repository.UserRepository;
import com.example.demogiftlist.security.jwt.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(
                () -> new BadCredentialsException("bad credentials!")
        );

        return new AuthResponse(user.getEmail(),jwtTokenUtil.generateToken(user.getEmail()),user.getRole());
    }

    public AuthResponse createUser(AuthRequest request) {
        User user = mapToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        return mapToResponse(userRepository.save(user));
    }

    public User mapToEntity(AuthRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .isBlock(true)
                .build();
    }

    public AuthResponse mapToResponse(User user) {
        String token = jwtTokenUtil.generateToken(user.getEmail());
        return AuthResponse.builder()
                .token(token)
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }
}

package com.example.chatTogether.controllers;

import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.dto.request.LoginRequest;
import com.example.chatTogether.dto.request.SignupRequest;
import com.example.chatTogether.dto.response.LoginResponse;
import com.example.chatTogether.dto.response.SignupResponse;
import com.example.chatTogether.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO<SignupResponse>> signup(@RequestBody @Valid SignupRequest request){
        return authService.signup(request);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<LoginResponse>> signup(@RequestBody @Valid LoginRequest request){
        return authService.login(request);
    }
}

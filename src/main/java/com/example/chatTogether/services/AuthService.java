package com.example.chatTogether.services;

import com.example.chatTogether.dto.MetaDTO;
import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.dto.request.LoginRequest;
import com.example.chatTogether.dto.request.SignupRequest;
import com.example.chatTogether.dto.response.LoginResponse;
import com.example.chatTogether.dto.response.SignupResponse;
import com.example.chatTogether.entities.User;
import com.example.chatTogether.entities.UserAuth;
import com.example.chatTogether.exceptions.SuccessCode;
import com.example.chatTogether.repositories.UserAuthRepository;
import com.example.chatTogether.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserAuthRepository userAuthRepository;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<ResponseDTO<SignupResponse>> signup(SignupRequest request){
        ResponseDTO<SignupResponse> response = new ResponseDTO<>();
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            response.setData(SignupResponse.builder()
                    .response("Username has been already taken")
                    .build());
            response.setMetaDTO(new MetaDTO(Boolean.TRUE, SuccessCode.SUCCESS, SuccessCode.SUCCESS, ""));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        User savedUser = userRepository.save(
                User.builder()
                        .username(request.getUsername())
                        .name(request.getName())
                        .dob(request.getDob())
                        .password(request.getPassword())
                .build()
        );
        String token = jwtService.generateToken(request.getUsername());
        userAuthRepository.save(
                UserAuth.builder()
                        .userId(savedUser.getId())
                        .expiryTime(LocalDateTime.now().plusDays(30))
                        .jwt(token)
                        .build()
        );
        response.setData(SignupResponse.builder()
                .response("User added successfully")
                .token(token)
                .build());
        response.setMetaDTO(new MetaDTO(Boolean.TRUE, SuccessCode.SUCCESS, SuccessCode.SUCCESS, ""));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO<LoginResponse>> login(LoginRequest request){
        ResponseDTO<LoginResponse> response = new ResponseDTO<>();

        return null;
    }
}

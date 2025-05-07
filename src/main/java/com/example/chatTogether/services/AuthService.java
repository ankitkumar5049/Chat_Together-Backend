package com.example.chatTogether.services;

import com.example.chatTogether.dto.MetaDTO;
import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.dto.request.SignupRequest;
import com.example.chatTogether.dto.response.SignupResponse;
import com.example.chatTogether.entities.User;
import com.example.chatTogether.exceptions.SuccessCode;
import com.example.chatTogether.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public ResponseEntity<ResponseDTO<SignupResponse>> signup(SignupRequest request){
        ResponseDTO<SignupResponse> response = new ResponseDTO<>();
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            response.setData(SignupResponse.builder()
                    .response("Username has been already taken")
                    .build());
            response.setMetaDTO(new MetaDTO(Boolean.TRUE, SuccessCode.SUCCESS, SuccessCode.SUCCESS, ""));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        userRepository.save(
                User.builder()
                        .username(request.getUsername())
                        .name(request.getName())
                        .dob(request.getDob())
                        .password(request.getPassword())
                .build()
        );
        response.setData(SignupResponse.builder()
                .response("User added successfully")
                .build());
        response.setMetaDTO(new MetaDTO(Boolean.TRUE, SuccessCode.SUCCESS, SuccessCode.SUCCESS, ""));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

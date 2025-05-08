package com.example.chatTogether.services;

import com.example.chatTogether.dto.MetaDTO;
import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.exceptions.SuccessCode;
import com.example.chatTogether.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final UserRepository userRepository;

    public ResponseEntity<ResponseDTO<Boolean>> isUsernameExist(String username){
        boolean exists = userRepository.findByUsername(username).isPresent();
        ResponseDTO<Boolean> response = new ResponseDTO<>();

        response.setData(exists);
        response.setMetaDTO(new MetaDTO(Boolean.TRUE, SuccessCode.SUCCESS, SuccessCode.SUCCESS, ""));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

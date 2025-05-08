package com.example.chatTogether.services;


import com.example.chatTogether.entities.UserAuth;
import com.example.chatTogether.repositories.JwtUserRepository;
import com.example.chatTogether.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtService {

    private final JwtUserRepository jwtUserRepository;
    private final JWTUtil jwtUtil;


    public String createJwt(Long userId) {

        String jwtToken = jwtUtil.generateToken(userId);
        //String finalToken = "Bearer "+ jwtToken;
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(userId);
        userAuth.setJwt(jwtToken);
        userAuth.setExpiryTime(jwtUtil.extractExpiration(jwtToken)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        userAuth.setCreatedAt(LocalDateTime.now());
        userAuth.setUpdatedAt(LocalDateTime.now());
        jwtUserRepository.save(userAuth);

        return jwtToken;
    }

    public boolean validateJwt(String jwt, Long userId) {
        UserAuth userAuth = jwtUserRepository.findByUserId(userId);
        String originalJwtKey = userAuth.getJwt();

        return Objects.equals(jwt, originalJwtKey);
    }
}

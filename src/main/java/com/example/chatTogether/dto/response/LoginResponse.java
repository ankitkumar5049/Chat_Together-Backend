package com.example.chatTogether.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String response;
    private String token;
}
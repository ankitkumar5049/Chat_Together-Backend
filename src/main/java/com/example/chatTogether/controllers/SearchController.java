package com.example.chatTogether.controllers;

import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.services.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<Boolean>> isUsernameExists(@RequestParam String username){
        return searchService.isUsernameExist(username);
    }
}

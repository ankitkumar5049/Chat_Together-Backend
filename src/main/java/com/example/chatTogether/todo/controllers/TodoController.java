package com.example.chatTogether.todo.controllers;

import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.todo.dto.TodoRequest;
import com.example.chatTogether.todo.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<String>> save(@RequestBody TodoRequest request){
        return todoService.save(request);
    }
}

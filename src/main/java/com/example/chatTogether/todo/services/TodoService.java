package com.example.chatTogether.todo.services;

import com.example.chatTogether.dto.MetaDTO;
import com.example.chatTogether.dto.ResponseDTO;
import com.example.chatTogether.exceptions.SuccessCode;
import com.example.chatTogether.todo.dto.TodoRequest;
import com.example.chatTogether.todo.entities.Todo;
import com.example.chatTogether.todo.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    public ResponseEntity<ResponseDTO<String>> save(TodoRequest request){
        Todo todo = Todo.builder()
                .title(request.getTitle())
                .userId(10)
                .content(request.getContent())
                .build();
        todoRepository.save(todo);
        ResponseDTO<String> response = new ResponseDTO<>();
        response.setData("Todo saved successfully");
        response.setMetaDTO(new MetaDTO(Boolean.TRUE, SuccessCode.SUCCESS, SuccessCode.SUCCESS, ""));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

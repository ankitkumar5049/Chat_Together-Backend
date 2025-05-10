package com.example.chatTogether.todo.repo;

import com.example.chatTogether.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<List<Todo>> findByUserId(long userId);
}

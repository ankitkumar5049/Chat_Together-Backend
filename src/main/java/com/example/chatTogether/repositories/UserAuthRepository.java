package com.example.chatTogether.repositories;

import com.example.chatTogether.entities.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

}

package com.example.chatTogether.repositories;

import com.example.chatTogether.entities.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtUserRepository extends JpaRepository<UserAuth, Long> {
    UserAuth findByUserId(Long userId);
    UserAuth findByJwt(String jwt);
}

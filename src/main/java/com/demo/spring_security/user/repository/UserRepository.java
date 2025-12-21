package com.demo.spring_security.user.repository;

import com.demo.spring_security.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String name);
}

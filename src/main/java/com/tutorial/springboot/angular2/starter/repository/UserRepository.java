package com.tutorial.springboot.angular2.starter.repository;

import com.tutorial.springboot.angular2.starter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

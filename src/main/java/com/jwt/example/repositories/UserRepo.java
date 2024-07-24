package com.jwt.example.repositories;

import com.jwt.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

}

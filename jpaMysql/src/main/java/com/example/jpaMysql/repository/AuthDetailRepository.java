package com.example.jpaMysql.repository;

import com.example.jpaMysql.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthDetailRepository extends JpaRepository<Auth,Integer> {

    Optional<Auth> findByUsername(String username);
}

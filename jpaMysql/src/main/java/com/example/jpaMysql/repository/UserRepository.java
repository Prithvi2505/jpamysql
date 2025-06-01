package com.example.jpaMysql.repository;

import com.example.jpaMysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByName(String name);
    public List<User> findByCity(String city);
    public List<User> findByAge(int age);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    public List<User> findByPartialName(@Param("name") String name);

}

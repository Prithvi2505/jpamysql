package com.example.jpaMysql.repository;

import com.example.jpaMysql.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationsRepository extends JpaRepository<Applications,Integer> {
}

package com.example.jpaMysql.repository;

import com.example.jpaMysql.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job,Integer> {
}

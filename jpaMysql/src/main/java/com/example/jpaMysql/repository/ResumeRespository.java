package com.example.jpaMysql.repository;

import com.example.jpaMysql.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRespository extends JpaRepository<Resume,Integer> {
}

package com.example.jpaMysql.service;

import com.example.jpaMysql.entity.Resume;
import com.example.jpaMysql.entity.User;
import com.example.jpaMysql.repository.ResumeRespository;
import com.example.jpaMysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    ResumeRespository resumeRepo;

    @Autowired
    UserRepository userRepo;

    public Resume addResume(int userId,Resume resume){
        Optional<User> u = userRepo.findById(userId);
        if(u.isPresent()){
            User user = u.get();
            resume.setUser(user);
            return  resumeRepo.save(resume);
        }
        else {
            throw new RuntimeException();
        }

    }


}

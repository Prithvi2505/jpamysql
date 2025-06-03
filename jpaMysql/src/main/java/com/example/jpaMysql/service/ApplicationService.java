package com.example.jpaMysql.service;

import com.example.jpaMysql.entity.Applications;
import com.example.jpaMysql.entity.User;
import com.example.jpaMysql.repository.ApplicationsRepository;
import com.example.jpaMysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    ApplicationsRepository repo;

    @Autowired
    UserRepository userRepo;

    public Applications addApplication(int id,Applications app){
        Optional<User> u = userRepo.findById(id);
        if(u.isPresent()){
            User user = u.get();
            app.setUser(user);
            return repo.save(app);
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<Applications> getAllApplications(){
        return repo.findAll();
    }

}

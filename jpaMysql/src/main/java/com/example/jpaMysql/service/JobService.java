package com.example.jpaMysql.service;

import com.example.jpaMysql.entity.Job;
import com.example.jpaMysql.entity.User;
import com.example.jpaMysql.repository.JobsRepository;
import com.example.jpaMysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    UserRepository userRepository;

    public Job addJob(Job job){
        return  jobsRepository.save(job);
    }

    public User addJobtoUser(int userid, int jobid){
        Optional<User> user  = userRepository.findById(userid);
        Optional<Job> job = jobsRepository.findById(jobid);
        if(user.isPresent() && job.isPresent()){
            user.get().getJobs().add(job.get());
            userRepository.save(user.get());
            return  user.get();
        }
        else {
            throw new IllegalArgumentException("User or Job not found");
        }
    }
    public List<Job> getAllJobs() {
        return jobsRepository.findAll();
    }

}

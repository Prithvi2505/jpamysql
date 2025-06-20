package com.example.jpaMysql.Controller;

import com.example.jpaMysql.entity.Job;
import com.example.jpaMysql.entity.User;
import com.example.jpaMysql.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    JobService jobService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Job> getalljobs(){
        return jobService.getAllJobs();
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Job> addJobs(@RequestBody Job job){
        return  ResponseEntity.ok(jobService.addJob(job));
    }
    @PostMapping("/addJobtoUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> addJobstoUser(@RequestParam int userid,@RequestParam int jobid){
        return  ResponseEntity.ok(jobService.addJobtoUser(userid,jobid));
    }
}

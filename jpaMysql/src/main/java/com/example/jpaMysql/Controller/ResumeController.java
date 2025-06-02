package com.example.jpaMysql.Controller;

import com.example.jpaMysql.entity.Resume;
import com.example.jpaMysql.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class ResumeController {
    @Autowired
    ResumeService service;

    @PostMapping("/{userid}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable int userid, @RequestBody Resume resume){
        return  ResponseEntity.ok(service.addResume(userid,resume));
    }
    @PutMapping("/{id}/upresume")
    public  ResponseEntity<Resume> updateResume(@PathVariable int id, @RequestBody Resume resume){
        return ResponseEntity.ok(service.updateResume(id, resume));
    }

}

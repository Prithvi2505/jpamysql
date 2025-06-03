package com.example.jpaMysql.Controller;


import com.example.jpaMysql.entity.Applications;
import com.example.jpaMysql.entity.Resume;
import com.example.jpaMysql.entity.User;
import com.example.jpaMysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<User> getallUsers() {
        List<User> userdata = repo.findAll();
        return userdata;
    }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void createUser(@RequestBody User user) {
        Resume resume = user.getResume();
        List<Applications>applications = user.getApplications();
        if(resume != null) {
            resume.setUser(user);
        }
        if(!applications.isEmpty()){
           for(Applications app : applications){
               app.setUser(user);
           }
        }
        repo.save(user);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public User getUserbyId(@PathVariable int id){
        return  repo.findById(id).get();
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void updateUserbyId(@PathVariable int id, @RequestBody User user){
        User userdata = repo.findById(id).get();
        userdata.setName(user.getName());
        userdata.setCity(user.getCity());
        userdata.setAge(user.getAge());
        repo.save(userdata);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUserbyId(@PathVariable int id){
        repo.deleteById(id);
    }

    @GetMapping("/name")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUserbyName(@RequestParam String name){
        return  repo.findByName(name);
    }
    @GetMapping("/city")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUserbyCity(@RequestParam String city){
        return  repo.findByCity(city);
    }
    @GetMapping("/age")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUserbyAge(@RequestParam int age){
        return  repo.findByAge(age);
    }
    @GetMapping("/pname")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUserbyPartialName(@RequestParam String name){
        return  repo.findByPartialName(name);
    }

}

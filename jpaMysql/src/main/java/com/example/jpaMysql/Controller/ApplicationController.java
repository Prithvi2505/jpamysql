package com.example.jpaMysql.Controller;

import com.example.jpaMysql.entity.Applications;
import com.example.jpaMysql.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/application")
public class ApplicationController {
@Autowired
    ApplicationService appService;

@PostMapping("/{userid}")
public ResponseEntity<Applications> addApplication(@PathVariable int userid, @RequestBody Applications applications){

    return ResponseEntity.ok(appService.addApplication(userid,applications));
}

}

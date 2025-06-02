package com.example.jpaMysql.Controller;

import com.example.jpaMysql.entity.AuthRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @GetMapping
    public String HealthCheck(){
        return "Checking Auth";
    }
    @PostMapping
    public String generateToken(@RequestBody AuthRequest authRequest){

        return "JWT TOKEN";
    }
}

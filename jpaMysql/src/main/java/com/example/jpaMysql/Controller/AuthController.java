package com.example.jpaMysql.Controller;

import com.example.jpaMysql.entity.AuthRequest;
import com.example.jpaMysql.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public String HealthCheck(){
        return "Checking Auth";
    }
    @PostMapping
    public String generateToken(@RequestBody AuthRequest authRequest){
        try {
                authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
                  );
                  return   jwtUtil.generateToken(authRequest.getUsername());

            }
        catch (Exception e){
            throw  e;
        }
    }
}

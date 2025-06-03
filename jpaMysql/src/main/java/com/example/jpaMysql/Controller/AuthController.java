package com.example.jpaMysql.Controller;

import com.example.jpaMysql.dto.RegisterRequest;
import com.example.jpaMysql.entity.Auth;
import com.example.jpaMysql.entity.AuthRequest;
import com.example.jpaMysql.repository.AuthDetailRepository;
import com.example.jpaMysql.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthDetailRepository authDetailRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
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
    @GetMapping("/addAuth")
    public String healthCheck(){
        return "Checking this path works";

    }
    @PostMapping("/addAuth")
    public void createNewAuth(@RequestBody RegisterRequest request){
        Auth user = new Auth();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        authDetailRepository.save(user);
    }
}

package com.example.jpaMysql.service;

import com.example.jpaMysql.entity.Auth;
import com.example.jpaMysql.repository.AuthDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminAuthInitializer {


    @Bean
    public CommandLineRunner createAdmin(AuthDetailRepository authDetailRepository, PasswordEncoder passwordEncoder){
        return  args -> {
            if(authDetailRepository.findByUsername("admin").isEmpty()){
                Auth admin = new Auth();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234"));
                admin.setRole("ROLE_ADMIN");

                authDetailRepository.save(admin);
                System.out.println("Default Admin User Created");
            }
            if(authDetailRepository.findByUsername("user").isEmpty()){
                Auth admin = new Auth();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("user1234"));
                admin.setRole("ROLE_USER");

                authDetailRepository.save(admin);
                System.out.println("Default  User Created");
            }
        };
    }
}

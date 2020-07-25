package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Chapter61Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter61Application.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "SpringBoot-Logback";
    }
}

package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Chapter63Application {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter63Application.class, args);
    }
}

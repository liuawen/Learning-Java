package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter33Application {

    public static void main(String[] args) {
        System.out.println("项目启动了");
        SpringApplication.run(Chapter33Application.class, args);
    }
}

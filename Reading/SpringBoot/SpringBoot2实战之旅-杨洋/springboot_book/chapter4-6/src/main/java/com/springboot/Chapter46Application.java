package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 启动类必须加入@ServletComponentScan注解，否则无法扫描到servlet
@ServletComponentScan
public class Chapter46Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter46Application.class, args);
    }

}

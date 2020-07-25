package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存
//@EnableCaching
public class Chapter13Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter13Application.class, args);
	}

}


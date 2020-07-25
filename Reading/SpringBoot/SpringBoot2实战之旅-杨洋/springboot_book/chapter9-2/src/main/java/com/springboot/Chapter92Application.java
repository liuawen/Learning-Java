package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class Chapter92Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter92Application.class, args);
	}

}


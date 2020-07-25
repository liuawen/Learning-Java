package com.dalaoyang;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringbootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAdminServerApplication.class, args);
	}
}

package com.dalaoyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients(basePackages = "com.dalaoyang.interfaces")
@EnableFeignClients
public class SpringcloudFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudFeignApplication.class, args);
	}
}

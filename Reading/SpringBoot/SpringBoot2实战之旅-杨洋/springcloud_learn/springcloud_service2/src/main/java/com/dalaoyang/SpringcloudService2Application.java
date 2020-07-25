package com.dalaoyang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class SpringcloudService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudService2Application.class, args);
	}

	@Value("${server.port}")
	String port;

	@Value("${spring.application.name}")
	String serviceName;

	@GetMapping("/")
	public String index(){
		return "serviceName=" + serviceName + "-------port=" + port;
	}
}

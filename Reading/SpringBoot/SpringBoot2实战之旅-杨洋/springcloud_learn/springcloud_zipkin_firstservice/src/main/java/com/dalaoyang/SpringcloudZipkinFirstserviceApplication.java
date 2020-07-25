package com.dalaoyang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringcloudZipkinFirstserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZipkinFirstserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Value("${spring.application.name}")
	String serviceName;

	@RequestMapping("/callSecond")
	public String callSecond(){
		return restTemplate().getForObject("http://localhost:9002/second", String.class);
	}


	@RequestMapping("/first")
	public String first(){
		return serviceName;

	}
}

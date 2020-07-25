package com.springboot;

import com.springboot.entity.BookConfigBean;
import com.springboot.entity.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({BookConfigBean.class,ConfigBean.class})
public class Chapter34Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter34Application.class, args);
	}
}

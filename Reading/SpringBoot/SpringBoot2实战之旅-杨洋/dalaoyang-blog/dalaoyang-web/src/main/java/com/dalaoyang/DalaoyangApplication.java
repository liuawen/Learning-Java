package com.dalaoyang;

import com.dalaoyang.interceptor.RequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DalaoyangApplication extends WebMvcConfigurerAdapter {

    @Autowired
    RequestLog requestLog;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLog);
    }

    public static void main(String[] args) {
        SpringApplication.run(DalaoyangApplication.class, args);
    }
}

package com.dalaoyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringcloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayApplication.class, args);
    }



    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/jianshu")
                        .uri("http://www.jianshu.com/u/128b6effde53")
                ).build();
    }

}

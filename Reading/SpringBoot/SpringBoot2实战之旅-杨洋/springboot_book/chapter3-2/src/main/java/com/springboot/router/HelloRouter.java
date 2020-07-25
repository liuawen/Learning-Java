package com.springboot.router;

import com.springboot.handle.HelloHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class    HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> routeHello(HelloHandle helloHandle) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        helloHandle::hello);
    }
}

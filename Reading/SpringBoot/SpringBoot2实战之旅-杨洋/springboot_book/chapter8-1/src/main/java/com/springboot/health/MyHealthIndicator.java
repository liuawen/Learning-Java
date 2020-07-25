package com.springboot.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    private final String defaultServerPort = "80";

    @Value("${server.port}")
    private String serverPort;

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code:", errorCode).build();
        }
        return Health.up().build();
    }

    public int check(){
        if(!defaultServerPort.equals(serverPort)){
            return 500;
        }
        return 0;
    }

}
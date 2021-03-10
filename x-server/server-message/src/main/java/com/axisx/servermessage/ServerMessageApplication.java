package com.axisx.servermessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.axisx.*"})
public class ServerMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerMessageApplication.class, args);
    }
}

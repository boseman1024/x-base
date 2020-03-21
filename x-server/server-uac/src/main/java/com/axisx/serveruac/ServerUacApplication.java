package com.axisx.serveruac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Axisx
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.axisx.*"})
@EnableFeignClients(basePackages = {"com.axisx.*"})
public class ServerUacApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerUacApplication.class, args);
    }

}

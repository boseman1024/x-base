package com.axisx.xauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Axisx
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableFeignClients(basePackages = {"com.axisx.*"})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.axisx.*"})
public class XAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XAuthApplication.class, args);
    }

}

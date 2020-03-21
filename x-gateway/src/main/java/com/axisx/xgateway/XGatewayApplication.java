package com.axisx.xgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Axisx
 */
@SpringBootApplication
@EnableDiscoveryClient
public class XGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(XGatewayApplication.class, args);
    }

}

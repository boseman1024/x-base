package com.axisx.serverworkflow;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableProcessApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.axisx.*"})
public class ServerWorkflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerWorkflowApplication.class, args);
    }

}

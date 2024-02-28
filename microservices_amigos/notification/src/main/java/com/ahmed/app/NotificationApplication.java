package com.ahmed.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.ahmed.app")
public class NotificationApplication {


    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }
}
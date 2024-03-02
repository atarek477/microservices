package com.ahmed.app;

import com.ahmed.app.configuration.NotificationConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication(scanBasePackages = "com.ahmed.app")
@EnableDiscoveryClient
@EnableFeignClients("com.ahmed.app")
public class NotificationApplication {


    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);




    }
//    CommandLineRunner commandLineRunner(RabbitMQProducer producer, NotificationConfiguration notificationConfiguration){
//        return args -> {
//            producer.publish("yeah",notificationConfiguration.getInternalExchange(),
//                    notificationConfiguration.getInternalNotificationRoutingkey());
//        };


 //   }

}
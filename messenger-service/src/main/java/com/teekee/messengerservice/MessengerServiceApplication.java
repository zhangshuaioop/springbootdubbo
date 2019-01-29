package com.teekee.messengerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.teekee.commoncomponets.hystrix","com.teekee.messengerservice"})
@EnableFeignClients(basePackages = {"com.teekee.commoncomponets.client"})
@EnableAutoConfiguration
public class MessengerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessengerServiceApplication.class, args);
    }

}


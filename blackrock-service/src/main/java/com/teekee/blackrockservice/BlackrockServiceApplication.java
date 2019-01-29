package com.teekee.blackrockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.teekee.commoncomponets.hystrix","com.teekee.blackrockservice"})
@EnableFeignClients(basePackages = {"com.teekee.commoncomponets.client"})
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class BlackrockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlackrockServiceApplication.class, args);
    }

}


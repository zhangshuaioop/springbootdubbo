package com.teekee.waterdropservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.teekee.commoncomponets.hystrix","com.teekee.waterdropservice"})
@EnableFeignClients(basePackages = {"com.teekee.commoncomponets.client"})
@EnableAutoConfiguration
public class WaterdropServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterdropServiceApplication.class, args);
    }

}


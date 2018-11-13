package com.baojufeng.servicepublic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.baojufeng.cloudfeign.hystrix", "com.baojufeng.servicepublic"})
@EnableFeignClients(basePackages = {"com.baojufeng.cloudfeign.client"})
@EnableAutoConfiguration
public class ServicePublicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePublicApplication.class, args);
    }


}

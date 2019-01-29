package com.teekee.blueoceanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.teekee.commoncomponets.hystrix","com.teekee.blueoceanservice"})
@EnableFeignClients(basePackages = {"com.teekee.commoncomponets.client"})
@EnableAutoConfiguration
public class BlueoceanServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlueoceanServiceApplication.class, args);
    }

}


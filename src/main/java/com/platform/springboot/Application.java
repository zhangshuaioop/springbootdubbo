package com.platform.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zs
 * on 2018/12/12.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args){
        new SpringApplication(Application.class).run(args);
    }
}

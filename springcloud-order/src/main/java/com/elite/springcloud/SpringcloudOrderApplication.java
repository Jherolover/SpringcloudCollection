package com.elite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients//开启Fegin
public class SpringcloudOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOrderApplication.class,args);
    }
}
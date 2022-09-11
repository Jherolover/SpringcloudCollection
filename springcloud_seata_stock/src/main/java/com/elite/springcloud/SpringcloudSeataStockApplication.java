package com.elite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients//开启Fegin
@SpringBootApplication
public class SpringcloudSeataStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSeataStockApplication.class,args);
    }
}
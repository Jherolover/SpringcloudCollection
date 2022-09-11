package com.elite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务注册
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserApplication.class,args);
    }
}
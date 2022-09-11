package com.elite.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开启nacos服务注册
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProductApplication.class,args);
    }
}
package com.elite.springcloud.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * 获取RestTemplate
 */
@Configuration
public class RestemplateConfig {
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * rocketmq:
     * #  name-server: 192.168.5.130:9876
     * #  producer:
     * #    group: springcloud-order
     * @return
     */
//    @Bean
//    public DefaultMQProducer getMQProducer(){
//        DefaultMQProducer producer = new DefaultMQProducer();
//        producer.setNamesrvAddr(" 192.168.5.130:9876");
//        producer.setProducerGroup("springcloud-order");
//        producer.setVipChannelEnabled(false);
//        return  producer;
//    }
}

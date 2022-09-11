package com.elite.springcloud.lsner;

import com.alibaba.fastjson.JSON;
import com.elite.springcloud.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//监听消息
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "springcloud-user", topic = "order-topic")
public class MessageLsner implements RocketMQListener<Order> {
    @Override
    public void onMessage(Order order) {
        log.info("订单信息:"+JSON.toJSONString(order));
    }
}
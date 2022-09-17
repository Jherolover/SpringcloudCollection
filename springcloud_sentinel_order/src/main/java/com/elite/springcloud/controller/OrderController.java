package com.elite.springcloud.controller;

import com.elite.springcloud.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-12
 */
@RestController
@RequestMapping("/springcloud/sentinel/order")
public class OrderController {

    int i = 0;
    @GetMapping("/message1")
    public String orderMessage(){
        i++;
        //异常比例为0.333
        if (i % 3 == 0){
            throw new RuntimeException();
        }
        return "订单消息！";
    }

    @GetMapping("/createOrder")
    public Order createOrder(){
        //订单信息
        Order order = new Order();
        order.setOrderNo(10);
        order.setProductId(1);
        order.setUserId(1);
        order.setOrderNum(1);
        order.setOrderAmt(BigDecimal.valueOf(100.0)); //单价*数量
        order.setOrderStatus("下单");
        order.setPayStatus("支付成功");
        order.setCreateBy("牛奶糖");
        order.setUpdateBy("牛奶糖");
        return order;
    }
}

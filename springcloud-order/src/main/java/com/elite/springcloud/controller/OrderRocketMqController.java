package com.elite.springcloud.controller;

import com.elite.springcloud.entity.Order;
import com.elite.springcloud.entity.Product;
import com.elite.springcloud.entity.User;
import com.elite.springcloud.interfaces.ProductService;
import com.elite.springcloud.service.IOrderService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 前端控制器
 * 下单控制
 * </p>
 *
 * @author elite
 * @since 2022-09-10
 */
@RestController
@RequestMapping("/springcloud/order/rocketmq")
public class OrderRocketMqController {

    //订单服务
    @Autowired
    IOrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    /**
     * 模拟下单 传入商品id,用户随机
     * @param product_id
     * @return
     */
    @GetMapping("/saveOrder/{product_id}")
    public String saveOrder(@PathVariable("product_id")Integer product_id ){
        //获取商品
        Product product = productService.getProductById(product_id);
        if (product == null){
            return "商品信息不存在";
        }
        //用户信息
        User user = new User();
        user.setUserId(1);
        //订单信息
        Order order = new Order();
        order.setOrderNo(10);
        order.setProductId(product_id);
        order.setUserId(user.getUserId());
        order.setOrderNum(1);
        order.setOrderAmt(product.getProductPrice());
        order.setOrderStatus("下单");
        order.setPayStatus("支付成功");
        order.setCreateBy("牛奶糖");
        order.setUpdateBy("牛奶糖");
        orderService.save(order);
        //下单成功之后,将消息放到mq中
        rocketMQTemplate.syncSend("order-topic", order,6000);
        //发布下单消息
        return "下单成功"+order.toString();
    }



}

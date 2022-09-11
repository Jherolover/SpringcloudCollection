package com.elite.springcloud.controller;

import com.elite.springcloud.entity.Order;
import com.elite.springcloud.entity.Product;
import com.elite.springcloud.entity.User;
import com.elite.springcloud.interfaces.ProductService;
import com.elite.springcloud.interfaces.UserService;
import com.elite.springcloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/springcloud/feign/order")
@Slf4j
public class OrderFeignController {

    @Autowired
    IOrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    private UserService userService;
    /**
     * 获取订单列表
     * @return
     */
    @GetMapping("/getOrderById/{order_id}")
    public HashMap<String,Object> getOrderById(@PathVariable("order_id")Integer order_id){
        HashMap<String,Object> res = new HashMap<>();
        //获取订单
        Order order = orderService.getById(order_id);
        res.put("order",order);
        //直接使用服务名字作为URL进行调用
        //获取用户
        User user = userService.getUserByUseId(order.getUserId());
        res.put("user",user);
        //获取商品信息
        Product product = productService.getProductById(order.getProductId());
        res.put("product",product);
        return res;
    }

}

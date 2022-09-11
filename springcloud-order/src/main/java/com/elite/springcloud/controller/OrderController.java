package com.elite.springcloud.controller;


import com.elite.springcloud.entity.Order;
import com.elite.springcloud.entity.Product;
import com.elite.springcloud.entity.User;
import com.elite.springcloud.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/springcloud/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @Autowired
    RestTemplate restTemplate;
    /**
     * 获取订单列表
     * @return
     */
    @GetMapping("/getOrderList")
    public List<Order> getOrderList(){
        return orderService.list();
    }
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
        //User user = restTemplate.getForObject("http://localhost:8081/springcloud/user/getUserByUseId/"+order.getUserId(), User.class);
        //res.put("user",user);
        //获取商品信息
        Product product = restTemplate.getForObject("http://springcloud-product/springcloud/product/getProductById/"+order.getProductId(), Product.class);
        res.put("product",product);
        return res;
    }
}

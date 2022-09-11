package com.elite.springcloud.controller;

import com.elite.springcloud.entity.Order;
import com.elite.springcloud.entity.Product;
import com.elite.springcloud.entity.User;
import com.elite.springcloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 从nacos服务中心获取实例进行调用
 *
 */
@RestController
@RequestMapping("/springcloud/nacos/order")
@Slf4j
public class Order4NacosController {

    @Autowired
    IOrderService orderService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
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
//        //从nacos服务注册中心获取user服务
//        ServiceInstance userServiceInstance =
//                discoveryClient.getInstances("springcloud-user").get(0);
//        String userUrl = userServiceInstance.getHost()+":"+userServiceInstance.getPort();
//        log.info("获取到的用户实例url:"+userUrl);
//        //获取用户
//        User user = restTemplate.getForObject("http://"+userUrl+"/springcloud/user/getUserByUseId/"+order.getUserId(), User.class);
//        res.put("user",user);
        //获取商品信息
        //从nacos服务注册中心获取product服务
        List<ServiceInstance> productServiceInstanceList =  discoveryClient.getInstances("springcloud-product");
        int index = new Random().nextInt(productServiceInstanceList.size());
        ServiceInstance productServiceInstance =
                discoveryClient.getInstances("springcloud-product").get(index);
        String productUrl = productServiceInstance.getHost()+":"+productServiceInstance.getPort();
        log.info("获取到的商品实例的url:"+productUrl);
        Product product = restTemplate.getForObject("http://"+productUrl+"/springcloud/product/getProductById/"+order.getProductId(), Product.class);
        res.put("product",product);
        return res;
    }
}

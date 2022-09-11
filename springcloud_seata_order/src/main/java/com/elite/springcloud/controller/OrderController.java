package com.elite.springcloud.controller;



import com.elite.springcloud.common.R;
import com.elite.springcloud.entity.Order;
import com.elite.springcloud.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    /**
     * 传入用户id 商品id下单
     * @param product_id
     * @param user_id
     * @return
     */
    @GetMapping("/createOrder/{product_id}/{user_id}/{product_num}")
    public R createOrder(@PathVariable("")Integer product_id,
                         @PathVariable("user_id") Integer user_id,
                         @PathVariable("product_num")Integer product_num){
         R r = orderService.createOrder(product_id,user_id,product_num);
        return r;
    }

}

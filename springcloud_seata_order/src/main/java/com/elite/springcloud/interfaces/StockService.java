package com.elite.springcloud.interfaces;

import com.elite.springcloud.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("springcloud-seata-stock")
public interface StockService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping 就是一个完整的请求路径
    @GetMapping(value = "/springcloud/stock/getProductById/{product_id}")
    Product getProductById(@PathVariable("product_id") Integer product_id);

    /**
     * 商品的id  商品的数量扣减库存
     * @param product_id
     * @return
     */
    @GetMapping(value = "/springcloud/stock/deductStock/{product_id}/{product_num}")
    boolean deductStock(@PathVariable("product_id") Integer product_id,@PathVariable("product_num") Integer product_num);
}

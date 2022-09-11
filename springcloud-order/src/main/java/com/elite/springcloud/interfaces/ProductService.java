package com.elite.springcloud.interfaces;

import com.elite.springcloud.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("springcloud-product")
public interface ProductService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping 就是一个完整的请求路径
    @GetMapping(value = "/springcloud/product/getProductById/{product_id}")
    Product getProductById(@PathVariable("product_id") Integer product_id);
}

package com.elite.springcloud.controller;


import com.elite.springcloud.entity.Product;
import com.elite.springcloud.service.IProductService;
import com.elite.springcloud.service.IStockService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库存表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/springcloud/stock")
public class StockController {

    @Autowired
    IProductService productService;

    @Autowired
    IStockService stockService;

    /**
     * 获取商品信息
     * @param product_id
     * @return
     */
    @GetMapping(value = "getProductById/{product_id}")
    public Product getProductById(@PathVariable("product_id") Integer product_id){
        return  productService.getById(product_id);
    }

    /**
     * 扣减库存
     * @param product_id
     * @param product_num
     * @return
     */
    @GetMapping(value = "/deductStock/{product_id}/{product_num}")
    boolean deductStock(@PathVariable("product_id") Integer product_id,@PathVariable("product_num") Integer product_num){
        return stockService.deuctStock(product_id,product_num);
    }
}

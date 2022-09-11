package com.elite.springcloud.controller;


import com.elite.springcloud.entity.Product;
import com.elite.springcloud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.PluginURLJarFileCallBack;

import java.util.List;

/**
 * /springcloud/product/getProductList
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/springcloud/product")
public class ProductController {

    @Autowired
    IProductService productService;

    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("/getProductList")
    public List<Product> getProductList(){
        return productService.list();
    }

    /**
     * 获取商品
     * @param product_id
     * @return
     */
    @GetMapping("/getProductById/{product_id}")
    public Product getProductById(@PathVariable("product_id")Integer product_id){
        return productService.getById(product_id);
    }
}

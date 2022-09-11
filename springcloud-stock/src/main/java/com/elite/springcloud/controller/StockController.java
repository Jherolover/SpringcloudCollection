package com.elite.springcloud.controller;


import com.elite.springcloud.entity.Stock;
import com.elite.springcloud.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 库存表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/springcloud/stock")
public class StockController {

    @Autowired
    IStockService stockService;

    /**
     * 获取库存列表
     * @return
     */
    @GetMapping("/getStockList")
    public List<Stock> getStockList(){
        return stockService.list();
    }

    /**
     * 获取库存ID
     * @param stock_id
     * @return
     */
    @GetMapping("/getStockById/{stock_id}")
    public Stock getStockById(@PathVariable("stock_id")Integer stock_id){
        return stockService.getById(stock_id);
    }
}

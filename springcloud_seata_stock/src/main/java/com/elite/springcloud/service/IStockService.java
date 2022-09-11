package com.elite.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elite.springcloud.entity.Stock;

/**
 * <p>
 * 库存表 服务类
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
public interface IStockService extends IService<Stock> {

    boolean deuctStock(Integer product_id, Integer product_num);
}

package com.elite.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elite.springcloud.entity.Stock;
import com.elite.springcloud.mapper.StockMapper;
import com.elite.springcloud.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

}

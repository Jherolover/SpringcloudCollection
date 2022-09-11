package com.elite.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elite.springcloud.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 库存表 Mapper 接口
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

}

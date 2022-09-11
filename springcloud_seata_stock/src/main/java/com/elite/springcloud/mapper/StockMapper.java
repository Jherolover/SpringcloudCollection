package com.elite.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elite.springcloud.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 库存表 Mapper 接口
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {
    @Update("UPDATE seata_stock.stock set stock_num = stock_num - #{product_num} WHERE product_id = #{product_id} and  (stock_num - #{product_num}) >= 0")
    boolean deuctStock(Integer product_id, Integer product_num);
}

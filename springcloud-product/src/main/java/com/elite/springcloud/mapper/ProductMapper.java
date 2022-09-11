package com.elite.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elite.springcloud.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}

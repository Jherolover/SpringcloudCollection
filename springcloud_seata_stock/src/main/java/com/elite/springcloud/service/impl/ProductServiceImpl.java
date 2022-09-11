package com.elite.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elite.springcloud.entity.Product;
import com.elite.springcloud.mapper.ProductMapper;
import com.elite.springcloud.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}

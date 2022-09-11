package com.elite.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elite.springcloud.common.R;
import com.elite.springcloud.entity.Order;
import com.elite.springcloud.entity.Product;
import com.elite.springcloud.entity.User;
import com.elite.springcloud.interfaces.AcctService;
import com.elite.springcloud.interfaces.StockService;
import com.elite.springcloud.mapper.OrderMapper;
import com.elite.springcloud.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    OrderMapper orderMapper;
    //库存服务
    @Autowired
    StockService stockService;
    //账户服务
    @Autowired
    AcctService acctService;
    /**
     * 下单服务
     * @param product_id
     * @param user_id
     * @return
     */
    @GlobalTransactional
    @Override
    public R createOrder(Integer product_id, Integer user_id,Integer product_num) {
        //库存服务：对给定的商品扣除仓储数量。
        Product product = stockService.getProductById(product_id);
        if (product == null){
            return R.fail(400,"商品信息为空，商品ID不能为空");
        }
        boolean deductSuccess = stockService.deductStock(product_id, product_num);
        if (!deductSuccess){
            return R.fail(400,"扣减库存失败！");
        }
        //验证用户
        User user = acctService.getUserByUseId(user_id);
        if (user == null){
            return R.fail(400,"传入的用户ID不存在");
        }
        //订单服务：根据采购需求创建订单。
        BigDecimal amt = (product.getProductPrice()).multiply(new BigDecimal(product_num  ));
        //订单信息
        Order order = new Order();
        order.setOrderNo(10);
        order.setProductId(product_id);
        order.setUserId(user.getUserId());
        order.setOrderNum(product_num);
        order.setOrderAmt(amt); //单价*数量
        order.setOrderStatus("下单");
        order.setPayStatus("支付成功");
        order.setCreateBy("牛奶糖");
        order.setUpdateBy("牛奶糖");
        orderMapper.insert(order);
        //模拟异常
        //int i = 1/0;
        //帐户服务：从用户帐户中扣除余额。
        boolean deductAcctFlag = acctService.deductAcct(user_id, amt);
        if (!deductAcctFlag){
            return R.fail(400,"扣减账户失败！");
        }
        return R.ok(200,"下单成功！",order);
    }
}

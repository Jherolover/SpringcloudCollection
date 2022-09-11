package com.elite.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elite.springcloud.entity.Account;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
public interface IAccountService extends IService<Account> {

    boolean deductAcct(Integer user_id, BigDecimal amt);
}

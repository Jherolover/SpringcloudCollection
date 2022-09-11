package com.elite.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elite.springcloud.entity.Account;
import com.elite.springcloud.mapper.AccountMapper;
import com.elite.springcloud.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {


    @Autowired
    AccountMapper accountMapper;

    /**
     * 扣减账户
     * @param user_id
     * @param amt
     * @return
     */
    @Override
    public boolean deductAcct(Integer user_id, BigDecimal amt) {
        return accountMapper.deductAcct(user_id,amt);
    }
}

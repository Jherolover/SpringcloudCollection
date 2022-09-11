package com.elite.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elite.springcloud.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 更新账户余额
     * @param user_id
     * @param amt
     * @return
     */
    @Update("UPDATE seata_account.account SET  acc_money= acc_money - #{amt} WHERE user_id = #{user_id} and (acc_money - #{amt}) >= 0")
    boolean deductAcct(Integer user_id, BigDecimal amt);
}

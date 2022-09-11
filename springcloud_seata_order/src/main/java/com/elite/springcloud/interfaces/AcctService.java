package com.elite.springcloud.interfaces;

import com.elite.springcloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient("springcloud-seata-account")
public interface AcctService {
    /**
     * 获取用户
     * @param user_id
     * @return
     */
    @GetMapping(value = "/springcloud/account/getUserByUseId/{user_id}")
    User getUserByUseId(@PathVariable("user_id") Integer user_id);

    /**
     * 下单扣减账户
     *
     */
    @GetMapping(value = "/springcloud/account/deductAcct/{user_id}/{amt}")
    boolean deductAcct(@PathVariable("user_id") Integer user_id, @PathVariable("amt")BigDecimal amt);

}

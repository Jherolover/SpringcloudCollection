package com.elite.springcloud.controller;


import com.elite.springcloud.entity.User;
import com.elite.springcloud.service.IAccountService;
import com.elite.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/springcloud/account")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @Autowired
    IUserService userService;


    /**
     * 获取用户
     * @param user_id
     * @return
     */
    @GetMapping(value = "/getUserByUseId/{user_id}")
    public User getUserByUseId(@PathVariable("user_id") Integer user_id){
        return userService.getById(user_id);
    }

    /**
     * 下单扣减账户
     *
     */
    @GetMapping(value = "/deductAcct/{user_id}/{amt}")
    public boolean deductAcct(@PathVariable("user_id") Integer user_id, @PathVariable("amt") BigDecimal amt){
      return accountService.deductAcct(user_id,amt);
    }
}

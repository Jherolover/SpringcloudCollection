package com.elite.springcloud.controller;


import com.elite.springcloud.entity.User;
import com.elite.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/springcloud/user")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/getUserList")
    public List<User> getUserList(){
        return userService.list();
    }
    /**
     * 获取用户
     * @param user_id
     * @return
     */

    @GetMapping("/getUserByUseId/{user_id}")
    public User getUserByUseId(@PathVariable("user_id")Integer  user_id){
        return userService.getById(user_id);
    }
}

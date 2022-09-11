package com.elite.springcloud.interfaces;

import com.elite.springcloud.entity.Product;
import com.elite.springcloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("springcloud-user")
public interface UserService {
    @GetMapping(value = "/springcloud/user/getUserByUseId/{user_id}")
    User getUserByUseId(@PathVariable("user_id") Integer user_id);
}

package com.elite.springcloud.service.impl;

import com.elite.springcloud.entity.User;
import com.elite.springcloud.mapper.UserMapper;
import com.elite.springcloud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

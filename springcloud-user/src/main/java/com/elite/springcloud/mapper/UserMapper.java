package com.elite.springcloud.mapper;

import com.elite.springcloud.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

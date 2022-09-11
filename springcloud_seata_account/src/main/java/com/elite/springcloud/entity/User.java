package com.elite.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 联系电话
     */
    private String userPhone;

    /**
     * 邮箱
     */
    private String userMail;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}

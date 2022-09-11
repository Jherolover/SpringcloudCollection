package com.elite.springcloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`user`")
public class User {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     *  年龄
     */
    @TableField(value = "user_age")
    private Integer userAge;

    /**
     *  用户电话
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     *  用户邮箱
     */
    @TableField(value = "user_mail")
    private String userMail;
    /**
     *  用户地址
     */
    @TableField(value = "user_address")
    private String userAddress;
    /**
     *  用户状态 1 活跃  0 禁用
     */
    @TableField(value = "user_status")
    private String userStatus;

    //创建人
    @TableField(value = "create_by")
    private String createBy;
    //创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;
    //更新人
    @TableField(value = "update_by")
    private String updateBy;
    //更新时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}

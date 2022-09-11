package com.elite.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
    @TableId(value = "acc_id", type = IdType.AUTO)
    private Integer accId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 账户钱数
     */
    private Integer accMoney;


}

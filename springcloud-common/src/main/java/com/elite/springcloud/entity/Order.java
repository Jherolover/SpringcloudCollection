package com.elite.springcloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author elite
 * @since 2022-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`order`")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单号
     */
    @TableField(value = "order_no")
    private Integer orderNo;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 订单产品数量
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 订单金额
     */
    @TableField(value = "order_amt")
    private BigDecimal orderAmt;

    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    private String orderStatus;

    /**
     * 支付状态
     */
    @TableField(value = "pay_status")
    private String payStatus;

    //创建人
    @TableField(value = "create_user")
    private String createBy;
    //创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;
    //更新人
    @TableField(value = "update_user")
    private String updateBy;
    //更新时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;


}
package com.elite.springcloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

/**
 * 商品表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`product`")
public class Product {

    /**
     * 商品ID
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    /**
     * 商品名
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 商品分类
     */
    @TableField(value = "product_type")
    private String productType;

    /**
     * 商品分类
     */
    @TableField(value = "product_price")
    private BigDecimal productPrice;

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

package com.elite.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 库存表
 * </p>
 *
 * @author elite
 * @since 2022-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 库存主键
     */
    @TableId(value = "stock_id", type = IdType.AUTO)
    private Integer stockId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 库存数量
     */
    private Integer stockNum;

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

    /**
     * 更新人
     */
    private String updateBy;


}

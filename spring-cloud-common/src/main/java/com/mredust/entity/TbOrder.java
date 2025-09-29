package com.mredust.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @TableName tb_order
 */
@TableName(value = "tb_order")
@Data
public class TbOrder {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long orderId;

    /**
     * 购买数量
     */
    private Integer count;

    /**
     * 花费价格
     */
    private BigDecimal price;
}
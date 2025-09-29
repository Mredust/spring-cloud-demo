package com.mredust.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName tb_storage
 */
@TableName(value ="tb_storage")
@Data
public class TbStorage {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 商品id
     */
    private Long orderId;

    /**
     * 库存
     */
    private Integer count;
}
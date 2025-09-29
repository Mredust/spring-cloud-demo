package com.mredust.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
public class SysUser {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     *
     */
    private Date createTime;
}
package com.mredust.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mredust.entity.SysUser;

import java.math.BigDecimal;

/**
 * @author Mredust
 * @description 针对表【sys_user】的数据库操作Service
 * @createDate 2025-09-27 15:23:17
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getUserById(Long id);

    boolean deductUserBalance(Long id, BigDecimal balance);
}

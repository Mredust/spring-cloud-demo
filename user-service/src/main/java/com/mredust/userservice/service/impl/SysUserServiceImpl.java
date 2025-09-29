package com.mredust.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mredust.entity.SysUser;
import com.mredust.userservice.mapper.SysUserMapper;
import com.mredust.userservice.service.SysUserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Mredust
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2025-09-27 15:23:17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {


    @Override
    public SysUser getUserById(Long id) {
        return this.getById(id);
    }

    @Override
    public boolean deductUserBalance(Long id, BigDecimal balance) {
        SysUser user = this.getById(id);
        BigDecimal userBalance = user.getBalance();
        if (userBalance.compareTo(balance) < 0) {
            return false;
        }
        user.setBalance(userBalance.subtract(balance));
        return this.updateById(user);
    }
}





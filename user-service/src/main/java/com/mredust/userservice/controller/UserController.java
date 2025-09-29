package com.mredust.userservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mredust.common.Result;
import com.mredust.entity.SysUser;
import com.mredust.userservice.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @description: UserController
 * @author: Mredust
 * @date: 2025-09-27 15:18
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    @SentinelResource("hot")
    @GetMapping("/{id}")
    public SysUser getUserById(@PathVariable Long id) throws InterruptedException {
        if (id == 1) {
            Thread.sleep(40);
        }
        return userService.getUserById(id);
    }

    @PostMapping("/{id}/deduct/balance/{balance}")
    public Result deductUserBalance(@PathVariable Long id, @PathVariable BigDecimal balance) {
        boolean flag = userService.deductUserBalance(id, balance);
        return Result.success(flag);
    }
}

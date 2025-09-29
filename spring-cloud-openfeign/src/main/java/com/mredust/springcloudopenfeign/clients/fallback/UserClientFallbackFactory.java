package com.mredust.springcloudopenfeign.clients.fallback;

import com.mredust.entity.SysUser;
import com.mredust.springcloudopenfeign.clients.UserClients;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.math.BigDecimal;

/**
 * @description: UserFallbackFactory
 * @author: Mredust
 * @date: 2025-09-27 19:41
 **/
public class UserClientFallbackFactory implements FallbackFactory<UserClients> {
    @Override
    public UserClients create(Throwable cause) {
        return new UserClients() {
            @Override
            public SysUser getUserById(Long id) {
                System.out.println("查询用户异常----降级处理");
                return new SysUser();
            }

            @Override
            public void deductUserBalance(Long id, BigDecimal balance) {
                System.out.println("扣减用户余额异常----降级处理");
            }
        };
    }
}

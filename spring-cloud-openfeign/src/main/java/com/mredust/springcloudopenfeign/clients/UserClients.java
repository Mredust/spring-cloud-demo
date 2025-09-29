package com.mredust.springcloudopenfeign.clients;


import com.mredust.entity.SysUser;
import com.mredust.springcloudopenfeign.clients.fallback.UserClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@FeignClient(value = "userservice", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClients {

    @GetMapping("/user/{id}")
    SysUser getUserById(@PathVariable("id") Long id);

    @PostMapping("/user/{id}/deduct/balance/{balance}")
    void deductUserBalance(@PathVariable("id") Long id, @PathVariable("balance") BigDecimal balance);

}

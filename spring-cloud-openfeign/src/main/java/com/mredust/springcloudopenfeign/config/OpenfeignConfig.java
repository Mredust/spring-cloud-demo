package com.mredust.springcloudopenfeign.config;

import com.mredust.springcloudopenfeign.clients.fallback.UserClientFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: OpenfeignConfig
 * @author: Mredust
 * @date: 2025-09-27 19:43
 **/
@Configuration
public class OpenfeignConfig {

    @Bean
    public UserClientFallbackFactory userClientFallbackFactory() {
        return new UserClientFallbackFactory();
    }
}

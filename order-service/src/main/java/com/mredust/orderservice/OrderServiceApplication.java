package com.mredust.orderservice;

import com.mredust.springcloudopenfeign.clients.StorageClients;
import com.mredust.springcloudopenfeign.clients.UserClients;
import com.mredust.springcloudopenfeign.config.OpenfeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.mredust.orderservice.mapper")
@EnableFeignClients(clients = {UserClients.class, StorageClients.class},
        defaultConfiguration = OpenfeignConfig.class)
@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

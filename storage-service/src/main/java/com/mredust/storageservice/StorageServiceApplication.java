package com.mredust.storageservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mredust.storageservice.mapper")
@SpringBootApplication
public class StorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }

}

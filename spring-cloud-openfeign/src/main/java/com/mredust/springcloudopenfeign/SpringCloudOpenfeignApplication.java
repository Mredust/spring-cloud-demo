package com.mredust.springcloudopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringCloudOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOpenfeignApplication.class, args);
    }

}

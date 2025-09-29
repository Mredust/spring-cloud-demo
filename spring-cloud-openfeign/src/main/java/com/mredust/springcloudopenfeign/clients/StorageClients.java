package com.mredust.springcloudopenfeign.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "storage-service")
public interface StorageClients {
    @PostMapping("/storage/{id}/deduct/count/{count}")
    void deductStorage(@PathVariable("id") Long id, @PathVariable("count") Integer count);
}

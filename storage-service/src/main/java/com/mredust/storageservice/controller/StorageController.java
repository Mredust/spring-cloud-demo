package com.mredust.storageservice.controller;

import com.mredust.common.Result;
import com.mredust.storageservice.service.TbStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: StorageController
 * @author: Mredust
 * @date: 2025-09-29 08:29
 **/
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    private TbStorageService storageService;

    @PostMapping("/{id}/deduct/count/{count}")
    public Result deductStorage(@PathVariable("id") Long id, @PathVariable("count") Integer count) {
      boolean flag =  storageService.deductStorage(id, count);
      return Result.success(flag);
    }
}

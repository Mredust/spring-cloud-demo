package com.mredust.storageservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mredust.entity.TbStorage;

/**
* @author Mredust
* @description 针对表【tb_storage】的数据库操作Service
* @createDate 2025-09-29 08:24:00
*/
public interface TbStorageService extends IService<TbStorage> {

    boolean deductStorage(Long id, Integer count);
}

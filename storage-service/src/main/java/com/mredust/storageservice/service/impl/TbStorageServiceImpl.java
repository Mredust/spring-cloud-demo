package com.mredust.storageservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.mredust.entity.TbStorage;
import com.mredust.storageservice.mapper.TbStorageMapper;
import com.mredust.storageservice.service.TbStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mredust
 * @description 针对表【tb_storage】的数据库操作Service实现
 * @createDate 2025-09-29 08:24:00
 */
@Service
public class TbStorageServiceImpl extends ServiceImpl<TbStorageMapper, TbStorage>
        implements TbStorageService {
    @Autowired
    private TbStorageMapper storageMapper;

    @Override
    public boolean deductStorage(Long id, Integer count) {
        TbStorage orderStorage = Db.lambdaQuery(TbStorage.class)
                .eq(id != null, TbStorage::getOrderId, id).one();
        Integer orderStorageCount = orderStorage.getCount();
        if (orderStorageCount - count < 0) {
            try {
                throw new Exception("库存不足");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        orderStorage.setCount(orderStorageCount - count);
        return this.updateById(orderStorage);
    }
}





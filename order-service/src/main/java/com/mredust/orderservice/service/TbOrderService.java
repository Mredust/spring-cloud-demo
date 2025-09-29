package com.mredust.orderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mredust.common.Result;
import com.mredust.entity.TbOrder;

/**
 * @author Mredust
 * @createDate 2025-09-27 15:23:17
 */
public interface TbOrderService extends IService<TbOrder> {


    Object getOrderById(Long id);

    Long addOrder(TbOrder order);
}

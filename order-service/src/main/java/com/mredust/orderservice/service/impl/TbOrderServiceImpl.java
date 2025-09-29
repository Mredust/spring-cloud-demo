package com.mredust.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mredust.entity.SysUser;
import com.mredust.entity.TbOrder;
import com.mredust.orderservice.mapper.TbOrderMapper;
import com.mredust.orderservice.service.TbOrderService;
import com.mredust.springcloudopenfeign.clients.StorageClients;
import com.mredust.springcloudopenfeign.clients.UserClients;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @author Mredust
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2025-09-27 15:23:17
 */
@Service
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder>
        implements TbOrderService {

    @Autowired
    private UserClients userClients;

    @Autowired
    private StorageClients storageClients;

    @Autowired
    private TbOrderMapper orderMapper;


    @Override
    public Object getOrderById(Long id) {
        HashMap<String, Object> orderMap = new HashMap<>();
        orderMap.put("id", id.toString());
        orderMap.put("name", "苹果电脑");
        orderMap.put("price", "10000");
        SysUser user = userClients.getUserById(1L);
        orderMap.put("user", user);
        return orderMap;
    }

    @Override
    @GlobalTransactional
    public Long addOrder(TbOrder order) {
        // 创建订单
        orderMapper.insert(order);
        try {
            // 调用远程服务扣减 库存，用户余额
            userClients.deductUserBalance(order.getUserId(), order.getPrice());
            storageClients.deductStorage(order.getOrderId(), order.getCount());
        } catch (Exception e) {
            System.out.println("下单失败：" + e.getMessage());
            throw new RuntimeException(e);
        }
        return order.getId();
    }
}





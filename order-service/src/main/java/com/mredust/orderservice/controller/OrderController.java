package com.mredust.orderservice.controller;

import com.mredust.common.Result;
import com.mredust.entity.TbOrder;
import com.mredust.orderservice.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: UserController
 * @author: Mredust
 * @date: 2025-09-27 15:18
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private TbOrderService orderService;

    @GetMapping("/{id}")
    public Object getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public Result<Long> addOrder(@RequestBody TbOrder order) {
        Long id = orderService.addOrder(order);
        return Result.success(id);
    }
}

package com.controller;

import com.entity.Order;
import com.entity.dto.OrderDTO;
import com.result.Result;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderCotroller {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Result addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return Result.ok("完成订单");
    }
}

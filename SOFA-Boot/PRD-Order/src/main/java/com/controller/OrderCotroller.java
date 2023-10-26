package com.controller;

import com.entity.Order;
import com.entity.dto.OrderDTO;
import com.result.Result;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderCotroller {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Result addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return Result.ok("添加完成");
    }

    @GetMapping("/list")
    public Result listAllOrder(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                               @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){
        orderService.listAllOrders(page,pageSize);
        return Result.ok();
    }



}

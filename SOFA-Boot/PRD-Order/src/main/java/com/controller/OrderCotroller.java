package com.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.entity.Order;
import com.entity.dto.OrderDTO;
import com.result.Result;
import com.service.BankCardService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderCotroller {

    @Autowired
    private OrderService orderService;

    @SofaReference(interfaceType = BankCardService.class,
            binding = @SofaReferenceBinding(bindingType = "bolt"))
    private BankCardService bankCardService;

    @PostMapping("/add")
    public Result addOrder(@RequestBody Order order){
        return Result.ok(orderService.addOrder(order));
    }

    @GetMapping("/list")
    public Result listAllOrder(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                               @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){
        orderService.listAllOrders(page,pageSize);
        return Result.ok();
    }

    @PostMapping("/pay")
    public Result payment(@RequestBody Long bankCart, BigDecimal price){
       Boolean flag= bankCardService.recharge(bankCart,price);
       if (flag){
           return Result.ok("交易成功");
       }else {
           return Result.fail("余额不足");
       }
    }

}

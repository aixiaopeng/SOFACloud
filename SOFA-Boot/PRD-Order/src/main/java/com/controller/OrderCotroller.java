package com.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.entity.Orders;
import com.entity.dto.OrderDTO;
import com.result.Result;
import com.service.ProductService;
import com.service.RPCBankCardService;
import com.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderCotroller {

    @Autowired
    private OrderService orderService;

    @SofaReference(interfaceType = RPCBankCardService.class,binding = @SofaReferenceBinding(bindingType = "bolt"), jvmFirst = false)
    private RPCBankCardService bankCardService;

    @SofaReference(interfaceType = ProductService.class,binding = @SofaReferenceBinding(bindingType = "bolt"), jvmFirst = false)
    private ProductService productService;




    @PostMapping("/add")
    public Result addOrder(@RequestBody Orders order){
        return Result.ok(orderService.addOrder(order));
    }

    @GetMapping("/list")
    public Result listAllOrder(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                               @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){
        return Result.ok(orderService.listOrders(page,pageSize));
    }

    @GetMapping("/listAll")
    public Result listAllOrderManager(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                               @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){
        return Result.ok(orderService.listAllOrders(page,pageSize));
    }

    @PostMapping("/pay")
    @Transactional
    public Result payment(@RequestBody Long bankCart, @RequestBody OrderDTO orderDTO){
       Boolean bankFlag= bankCardService.comsume(bankCart,orderDTO);
       Boolean productFlag= productService.consumeProduct(orderDTO.getProductId(),orderDTO.getNum().longValue());

       if(!bankFlag){
           return Result.fail("余额不足");
       }
       if(!productFlag){
           return Result.fail("商品数量不足");
       }
        return Result.ok("交易成功");
    }

}

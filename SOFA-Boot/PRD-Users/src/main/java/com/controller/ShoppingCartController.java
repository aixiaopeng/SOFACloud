package com.controller;

import com.entity.ShoppingCart;
import com.entity.vo.LoginUser;
import com.mapper.ShoppingCartMapper;
import com.result.Result;
import com.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/add")
    public Result addShoppingCart(@RequestParam Long productId){
      boolean flag= shoppingCartService.addShoppingCart(productId);
    if (flag==false){
        return Result.fail("商品已在购物车");
    }else {
        return Result.ok("添加成功");
    }
    }

   @GetMapping("/list")
    public Result listAddShoppingCart(@RequestParam Long userId,
                                       @RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                       @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){
        return Result.ok(shoppingCartService.listAddShoppingCart(userId,page,pageSize));
    }
}

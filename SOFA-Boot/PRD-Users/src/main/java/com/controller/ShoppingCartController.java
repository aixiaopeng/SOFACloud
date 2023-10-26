package com.controller;

import com.entity.Product;
import com.entity.ShoppingCart;
import com.entity.vo.LoginUser;
import com.entity.vo.ShoppingCartVO;
import com.mapper.ShoppingCartMapper;
import com.result.Result;
import com.service.ShoppingCartService;
import com.utils.NowTime;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/shoppingcart")

public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;


    @GetMapping("/add")
    public Result addShoppingCart(@RequestParam Long productId){
      shoppingCartService.addShoppingCart(productId);

        return Result.ok("添加成功");

    }

   @GetMapping("/list")
    public Result listAddShoppingCart(
                                       @RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                       @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){

    List<ShoppingCartVO> productList=  shoppingCartService.listAddShoppingCart(page,pageSize);
    if(Objects.isNull(productList)){
        return Result.fail("空无一物");
    }
        return Result.ok(productList);
    }

    @DeleteMapping("delete")
    public Result deleteShoppingCart(@PathVariable Long shoppingCartId){
        ShoppingCart shoppingCart = shoppingCartService.getById(shoppingCartId);
        shoppingCart.setDeletedAt(NowTime.setNowTime());

        shoppingCartService.updateById(shoppingCart);
        return Result.ok("删除成功");
    }
}

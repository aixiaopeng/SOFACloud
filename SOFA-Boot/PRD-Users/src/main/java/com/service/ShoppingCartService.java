package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 15012
* @description 针对表【shopping_cart】的数据库操作Service
* @createDate 2023-10-22 21:33:45
*/
public interface ShoppingCartService extends IService<ShoppingCart> {
    void addShoppingCart(Long productId);

    Page<ShoppingCart> listAddShoppingCart(Long userId,int page, int pageSize);
}

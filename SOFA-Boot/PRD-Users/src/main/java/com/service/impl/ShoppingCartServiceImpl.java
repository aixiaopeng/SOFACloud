package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.ShoppingCart;
import com.service.ShoppingCartService;
import com.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【shopping_cart】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}





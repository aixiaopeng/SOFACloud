package com.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.ShoppingCart;
import com.entity.vo.LoginUser;
import com.service.ShoppingCartService;
import com.mapper.ShoppingCartMapper;
import com.utils.NowTime;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author 15012
* @description 针对表【shopping_cart】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addShoppingCart(Long productId) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();

        //购物车是否存在该数据
        ShoppingCart shoppingCart = new LambdaQueryChainWrapper<>(shoppingCartMapper).eq(ShoppingCart::getUserId, userId).eq(ShoppingCart::getProductId, productId).one();
        if(!Objects.isNull(shoppingCart)){
            Integer num=shoppingCart.getNum();
            shoppingCart.setNum(num+1);
            shoppingCartMapper.updateById(shoppingCart);
            return;
        }

        shoppingCart=new ShoppingCart();
        shoppingCart.setUserId(userId);
        shoppingCart.setProductId(productId);
        shoppingCart.setNum(1);
        shoppingCartMapper.insert(shoppingCart);

    }

    @Override
    public Page<ShoppingCart> listAddShoppingCart(Long userId,int page, int pageSize) {
        Page<ShoppingCart> Page = new Page<>(page, pageSize);
        Page<ShoppingCart> shoppingCarts = new LambdaQueryChainWrapper<>(shoppingCartMapper).isNull(ShoppingCart::getDeletedAt).eq(ShoppingCart::getUserId,userId).page(Page);

        return shoppingCarts;
    }
}





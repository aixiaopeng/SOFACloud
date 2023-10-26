package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Product;
import com.entity.ShoppingCart;
import com.entity.vo.LoginUser;
import com.entity.vo.ShoppingCartVO;
import com.service.ProductService;
import com.service.ShoppingCartService;
import com.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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


    @SofaReference(interfaceType = ProductService.class, jvmFirst = false,
            binding = @SofaReferenceBinding(bindingType = "bolt"))
    private ProductService productService;


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
    public List<ShoppingCartVO> listAddShoppingCart(int page, int pageSize) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();

        Page<ShoppingCart> Page = new Page<>(page, pageSize);

            List<ShoppingCart> shoppingCarts = new LambdaQueryChainWrapper<>(shoppingCartMapper).isNull(ShoppingCart::getDeletedAt).eq(ShoppingCart::getUserId,userId).page(Page).getRecords();

            //购物车不存在
            if(shoppingCarts.size()==0){
                return null;
            }

        // 使用Stream提取productIds
        List<Long> productIds = shoppingCarts.stream()
                .map(ShoppingCart::getProductId)
                .collect(Collectors.toList());

            //用map来保存购物车对对应商品的数量
        Map<Long, Integer> NumMap = shoppingCarts.stream()
                .collect(Collectors.toMap(ShoppingCart::getProductId, ShoppingCart::getNum));


            //RPC调用商品模块
            List<ShoppingCartVO> products= productService.listProductByIds(productIds);

            //遍历购物车并存入数据
        for (ShoppingCartVO product : products) {
            product.setNum(NumMap.get(product.getProductId()));
        }

            return products;



    }
}





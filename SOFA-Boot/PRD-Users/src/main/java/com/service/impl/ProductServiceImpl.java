package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Product;
import com.entity.vo.ShoppingCartVO;
import com.mapper.ProductMapper;

import com.service.ProductService;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 15012
 * @description 针对表【product】的数据库操作Service实现
 * @createDate 2023-10-22 12:34:08
 */
@Service
@SofaService(interfaceType = ProductService.class, bindings = {
        @SofaServiceBinding(bindingType = "bolt")
})
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Autowired
    private ProductMapper productMapper;



    @Override
    public List<ShoppingCartVO> listProductByIds(List<Long> ids) {
        LambdaQueryWrapper<Product> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.in(Product::getId,ids);



        List<Product> products= productMapper.selectList(queryWrapper);

        List<ShoppingCartVO> shoppingCartVOS = products.stream()
                .map(product -> {
                    ShoppingCartVO cartVO = new ShoppingCartVO();
                    cartVO.setImgUrl(product.getImgurl());
                    cartVO.setName(product.getName());
                    cartVO.setDescription(product.getDescription());
                    cartVO.setPrice(product.getPrice());
                    cartVO.setDiscountPrice(product.getDiscountPrice());
                    cartVO.setCreatedAt(NowTime.setNowTime());
                    cartVO.setProductId(product.getId());
                    return cartVO;
                })
                .collect(Collectors.toList());

        return shoppingCartVOS;
    }

    public String makeDraft(Product product){
        product.setStatus(2);
        this.save(product);
        return "保存草稿成功";
    }


}





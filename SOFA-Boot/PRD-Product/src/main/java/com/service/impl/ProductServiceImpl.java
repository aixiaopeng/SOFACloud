package com.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Product;
import com.service.ProductService;
import com.mapper.ProductMapper;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 15012
 * @description 针对表【product】的数据库操作Service实现
 * @createDate 2023-10-22 12:34:08
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<Product> listAllProduct(int page, int pageSize, int sorted,Long categoryId) {
        // 创建分页对象
        Page<Product> productPage = new Page<>(page, pageSize);


        // 使用 LambdaQueryChainWrapper 查询
        LambdaQueryChainWrapper<Product> queryWrapper = new LambdaQueryChainWrapper<>(productMapper)
                .isNull(Product::getDeletedAt)
                .le(Product::getDiscountEnd, NowTime.setNowTime());

        if (sorted == 1) { //根据销量降序排序
            queryWrapper.orderByDesc(Product::getSold);
        } else if (sorted == 2) {  //根据销量升序序排序
            queryWrapper.orderByAsc(Product::getSold);
        } else if (sorted==3) {   //根据价格降序
            queryWrapper.orderByDesc(Product::getPrice);
        } else if (sorted==4) {   //根据价格升序
            queryWrapper.orderByAsc(Product::getPrice);
        }

        if (categoryId != null) {
            queryWrapper.eq(Product::getCategory, categoryId);
        }


        return queryWrapper.page(productPage);
    }

    @Override
    public Page<Product> listAllCountProduct(int page, int pageSize) {

        // 创建分页对象
        Page<Product> productPage = new Page<>(page, pageSize);
        Page<Product> products = new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).ge(Product::getDiscountEnd, NowTime.setNowTime()).page(productPage);

        return products;
    }

    @Override
    public List<Product> listPic() {
       List<Product> products= new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).orderByDesc(Product::getPriority).last("LIMIT 5").list();
        return products;
    }
}





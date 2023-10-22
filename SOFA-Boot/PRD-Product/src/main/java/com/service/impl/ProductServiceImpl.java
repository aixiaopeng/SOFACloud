package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Product;
import com.service.ProductService;
import com.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【product】的数据库操作Service实现
* @createDate 2023-10-22 12:34:08
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}





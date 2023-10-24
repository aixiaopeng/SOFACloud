package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 15012
* @description 针对表【product】的数据库操作Service
* @createDate 2023-10-22 12:34:09
*/
public interface ProductService extends IService<Product> {
    Page<Product> listAllProduct(int page,int pageSize,int sorted,Long categoryId);

    Page<Product> listAllCountProduct(int page,int pageSize);

    List<Product> listPic();

}

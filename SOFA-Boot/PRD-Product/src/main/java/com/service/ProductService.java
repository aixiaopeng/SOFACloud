package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.vo.ShoppingCartVO;
import com.result.Result;

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

    Page<Product> listAllNewProduct(int page,int pageSize);

    Result getProduct(Long id);

    String editProduct(Product product);

    String ExamSuccess(Long id,String s);

    String ExamFail(Long id,String s);

    String makeDraft(Product product);

    Page<Product> ListManageProduct(int page,int pageSize,String name);
    String downlineProduct(Long id);
    String uplineProduct(Long id);



    List<ShoppingCartVO> listProductByIds(List<Long> ids);

}

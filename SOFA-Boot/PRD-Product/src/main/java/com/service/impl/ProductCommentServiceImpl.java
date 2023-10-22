package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.ProductComment;
import com.service.ProductCommentService;
import com.mapper.ProductCommentMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【product_comment】的数据库操作Service实现
* @createDate 2023-10-22 12:34:09
*/
@Service
public class ProductCommentServiceImpl extends ServiceImpl<ProductCommentMapper, ProductComment>
    implements ProductCommentService{

}





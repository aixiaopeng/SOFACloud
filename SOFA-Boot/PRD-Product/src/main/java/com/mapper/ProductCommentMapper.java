package com.mapper;

import com.entity.ProductComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15012
* @description 针对表【product_comment】的数据库操作Mapper
* @createDate 2023-10-22 12:34:09
* @Entity com.entity.ProductComment
*/
@Mapper
public interface ProductCommentMapper extends BaseMapper<ProductComment> {

}





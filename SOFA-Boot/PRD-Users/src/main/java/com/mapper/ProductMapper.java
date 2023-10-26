package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15012
* @description 针对表【product】的数据库操作Mapper
* @createDate 2023-10-22 12:34:08
* @Entity com.entity.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}





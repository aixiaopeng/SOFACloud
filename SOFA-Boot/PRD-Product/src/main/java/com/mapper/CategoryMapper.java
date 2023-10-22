package com.mapper;

import com.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15012
* @description 针对表【category】的数据库操作Mapper
* @createDate 2023-10-22 12:34:09
* @Entity com.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}





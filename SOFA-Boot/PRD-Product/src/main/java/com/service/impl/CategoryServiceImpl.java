package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Category;
import com.service.CategoryService;
import com.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【category】的数据库操作Service实现
* @createDate 2023-10-22 12:34:09
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}





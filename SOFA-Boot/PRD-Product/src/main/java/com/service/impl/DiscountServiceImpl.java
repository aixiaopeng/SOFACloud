package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Discount;
import com.service.DiscountService;
import com.mapper.DiscountMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【discount】的数据库操作Service实现
* @createDate 2023-10-22 12:34:09
*/
@Service
public class DiscountServiceImpl extends ServiceImpl<DiscountMapper, Discount>
    implements DiscountService{

}





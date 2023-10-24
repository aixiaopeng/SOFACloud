package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Order;
import com.service.OrderService;
import com.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【order(订单信息表，用于存储用户订单信息)】的数据库操作Service实现
* @createDate 2023-10-24 11:48:38
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}





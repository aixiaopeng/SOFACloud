package com.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Order;
import com.entity.dto.OrderDTO;
import com.service.OrderService;
import com.mapper.OrderMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【order(订单信息表，用于存储用户订单信息)】的数据库操作Service实现
* @createDate 2023-10-24 11:48:38
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Page<Order> listAllOrders(int page, int pageSize, Long userId) {
        Page<Order> Page = new Page<>(page, pageSize);
        Page<Order> orderPage = new LambdaQueryChainWrapper<>(orderMapper).isNull(Order::getDeletedAt).eq(Order::getUserId,userId).page(Page);

        return orderPage;
    }

    @Override
    public void addOrder(Order order) {

        orderMapper.insert(order);
    }
}





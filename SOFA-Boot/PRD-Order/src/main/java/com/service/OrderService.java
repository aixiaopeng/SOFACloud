package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.dto.OrderDTO;

/**
* @author 15012
* @description 针对表【order(订单信息表，用于存储用户订单信息)】的数据库操作Service
* @createDate 2023-10-24 11:48:38
*/
public interface OrderService extends IService<Order> {

    Page<Order> listAllOrders(int page, int pageSize);

    void addOrder(Order order);

}

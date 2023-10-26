package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Order;
import com.entity.dto.OrderDTO;
import com.entity.vo.LoginUser;
import com.entity.vo.OrderVO;
import com.service.BankCardService;
import com.service.OrderService;
import com.mapper.OrderMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.utils.SnowflakeIdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
    public Page<Order> listAllOrders(int page, int pageSize) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();


        Page<Order> Page = new Page<>(page, pageSize);
        Page<Order> orderPage = new LambdaQueryChainWrapper<>(orderMapper).isNull(Order::getDeletedAt).eq(Order::getUserId,userId).page(Page);

        return orderPage;
    }

    @Override
    public Order addOrder(Order order) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();
        Long id=SnowflakeIdWorker.snowFlake();
        //存入数据库
        order.setId(id);
        order.setUserId(userId);
        order.setUserName(userDetails.getUsername());
        order.setPhone(userDetails.getPhone());
        order.setStatus("0");
        orderMapper.insert(order);

        Order order1= orderMapper.selectById(id);
        return order1;



    }


}





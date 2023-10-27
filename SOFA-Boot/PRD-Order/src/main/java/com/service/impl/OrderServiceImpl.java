package com.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Orders;
import com.entity.dto.OrderDTO;
import com.entity.vo.LoginUser;
import com.entity.vo.OrderVO;
import com.service.OrderService;
import com.mapper.OrderMapper;
import com.utils.JwtUtil;
import com.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【order(订单信息表，用于存储用户订单信息)】的数据库操作Service实现
* @createDate 2023-10-24 11:48:38
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public Page<Orders> listOrders(int page, int pageSize) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();


        Page<Orders> Page = new Page<>(page, pageSize);
        Page<Orders> orderPage = new LambdaQueryChainWrapper<>(orderMapper).isNull(Orders::getDeletedAt).eq(Orders::getUserId,userId).page(Page);

        return orderPage;
    }

    @Override
    public Page<Orders> listAllOrders(int page, int pageSize) {
        Page<Orders> Page = new Page<>(page, pageSize);
        Page<Orders> orderPage = new LambdaQueryChainWrapper<>(orderMapper).isNull(Orders::getDeletedAt).page(Page);

        return orderPage;
    }

    @Override
    public OrderVO addOrder(Orders order) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();

        //存入数据库
        Long orderNum=SnowflakeIdWorker.snowFlake();

        order.setOrderNum(orderNum);
        order.setUserId(userId);
        order.setUserName(userDetails.getUsername());
        order.setPhone(userDetails.getPhone());
        order.setStatus("0");
        try {
            this.save(order);
        }catch (Exception e){
            e.printStackTrace();
        }

       Orders orders= new LambdaQueryChainWrapper<>(orderMapper).eq(Orders::getUserId,userId).eq(Orders::getProductId,order.getProductId()).eq(Orders::getCreatedAt,order.getCreatedAt()).one();

        //生成token返回前端
      String orderToken=  JwtUtil.createJWT(orderNum.toString());



        OrderVO orderDTO=new OrderVO();
        orderDTO.setOrderToken(orderToken);


        orderDTO.setUserName(order.getUserName());
        orderDTO.setPhone(order.getPhone());
        orderDTO.setAddr(order.getAddr());


        orderDTO.setPrice(order.getPrice());
        orderDTO.setProductName(order.getProductName());
        orderDTO.setDiscountPrice(order.getDiscountprice());

        orderDTO.setCreatedAt(order.getCreatedAt());



        return orderDTO;



    }


}





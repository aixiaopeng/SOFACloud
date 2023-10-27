//package com.controller;
//
//
//import com.alipay.sofa.runtime.api.annotation.SofaReference;
//import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
//import com.entity.Orders;
//import com.service.OrderService;
//import com.service.ProductService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@RocketMQMessageListener(topic = "SeckkillTopic", consumerGroup = "consumer_grp_01")
//public class seckkillConsumer implements RocketMQListener<Orders> {
//
//    @Autowired
//    private OrderService orderService;
//
//    @SofaReference(interfaceType = ProductService.class, uniqueId = "${service.unique.id}", binding = @SofaReferenceBinding(bindingType = "bolt"))
//    private ProductService productService;
//
//    @Override
//    public void onMessage(Orders order) {/*
//        JSONArray jsonArray = JSON.parseArray(msg);
//        Order order = (Order) JSONObject.parseArray(jsonArray.toJSONString(), Order.class);*/
//        order.setPrice(productService.getById(order.getProductId()).getPrice());
//        orderService.updateById(order);
//        Long id = order.getProductId();
//        Long num = order.getOrderNum();
//        productService.consumeProduct(id,num);
//    }
//
//}
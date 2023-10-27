package com.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.entity.Orders;
import com.entity.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/discount")
@Slf4j
@CrossOrigin(origins = "*")
public class ProducerController {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

   @RequestMapping(value = "/seckill/{id}", method = {RequestMethod.GET, RequestMethod.POST})
   public String seckill(@PathVariable long id) throws InterruptedException {
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       LoginUser userDetails= (LoginUser) principal;
       long userId=userDetails.getUserId();
       //判断链接是否正常，如果正常进行抢单操作。
       String key = "productId: "+id;
           if(orderHandler(id,userId)){
               return "恭喜" + userId + "用户，抢单成功";
           }else {
               return "抱歉"+ userId +"用户,商品已经抢光，欢迎下次再来。";
           }
   }

    private synchronized boolean orderHandler(Long id,Long userId){
        String key = "productId: "+id;
        // 第二步：减少库存
        Long value = redisTemplate.opsForValue().decrement(key);
        // 库存充足
        if (value >=0) {
            // 通过 rocketmq 发送创建订单的消息，并且 update 数据库中商品库存。
            boolean res = createOrder(id, value);
            //如果下订单成功，返回。
            if (res) {
                return true;
            }
        } else {
            log.info("商品已经抢光，欢迎下次再来。");
        }
        //如果下单失败，则恢复库存。
        redisTemplate.opsForValue().increment(key);
        return false;
    }

    private boolean createOrder(Long id, Long value) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;

        Orders order = new Orders();
        order.setProductId(id);
        order.setOrderNum(1L);
        order.setAddr(userDetails.getAddr());
        order.setUserId(userDetails.getUserId());
        //需要捕获各种异常
        try {
            return sendMsg(order);
        } catch (Exception e) {
            log.info("{}", e);
        }
        return false;
    }


    public boolean sendMsg(Orders order) {

        //设置主题,超时时间为1s,同步发送
        SendResult sendResult = rocketMQTemplate.syncSend("SeckkillTopic", order, 1000);
        log.info(sendResult.toString());
        //发送成功，则返回成功
        return SendStatus.SEND_OK.equals(sendResult.getSendStatus());
    }

}
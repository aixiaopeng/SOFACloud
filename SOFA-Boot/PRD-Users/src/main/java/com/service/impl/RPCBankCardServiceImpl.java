package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.BankCard;
import com.entity.dto.OrderDTO;
import com.mapper.BankCardMapper;
import com.mysql.jdbc.StringUtils;
import com.service.BankCardService;
import com.service.RPCBankCardService;
import com.utils.CommonRedisHelper;
import com.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service

@SofaService(interfaceType = RPCBankCardService.class,bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class RPCBankCardServiceImpl extends ServiceImpl<BankCardMapper, BankCard>
        implements RPCBankCardService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean consume( Long bankCardId, OrderDTO orderDTO) {

      String token=  (String)redisTemplate.opsForValue().get("orderToken:"+orderDTO.getOrderId());



        Boolean result=false;
        if(token.equals(orderDTO.getOrderToken())){  //若token与订单匹配
            CommonRedisHelper redisHelper = new CommonRedisHelper();
            Boolean flag=redisHelper.lock("consumeKey");

            if(flag){  //获取锁

                result=this.setNXConsume(bankCardId,orderDTO); //开始消费
                redisHelper.delete("consumeKey");   //释放锁
            }else {
                // 设置失败次数计数器, 当到达5次时, 返回失败
                int failCount = 1;
                while(failCount <= 5){
                    // 等待100ms重试
                    try {
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (redisHelper.lock("consumeKey")){

                        result=this.setNXConsume(bankCardId,orderDTO); //开始消费
                        redisHelper.delete("consumeKey");
                    }else{
                        failCount ++;
                    }
                }
                throw new RuntimeException("现在创建的人太多了, 请稍等再试");
            }
        }
        return result;
    }



    public Boolean setNXConsume(Long bankCardId, OrderDTO orderDTO){
        BankCard bankCard=  this.getById(bankCardId);

        if(!Objects.isNull(bankCardId)){     //银行卡不为空
            if(bankCard.getAccount().compareTo(orderDTO.getPrice())>0){  //余额够消费
                bankCard.setAccount(bankCard.getAccount().subtract(orderDTO.getPrice()));  //扣除余额
                this.updateById(bankCard);    //更新数据库
                return true;
            }
        }
        return false;
    }
}

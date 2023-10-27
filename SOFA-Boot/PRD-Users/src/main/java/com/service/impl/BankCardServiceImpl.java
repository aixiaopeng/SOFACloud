package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.BankCard;
import com.entity.dto.OrderDTO;
import com.entity.vo.LoginUser;
import com.mysql.jdbc.StringUtils;
import com.result.Result;
import com.service.BankCardService;
import com.mapper.BankCardMapper;
import com.service.ProductService;
import com.utils.CommonRedisHelper;
import com.utils.JwtUtil;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
* @author 15012
* @description 针对表【bank_card】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
@SofaService(interfaceType = BankCardService.class, bindings = {
        @SofaServiceBinding(bindingType = "bolt")
})
public class BankCardServiceImpl extends ServiceImpl<BankCardMapper, BankCard>
    implements BankCardService{

    @Autowired
private BankCardMapper bankCardMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean addBankCard(BankCard bankCard) {
        Long userId=null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            LoginUser userDetails= (LoginUser) principal;
            userId=userDetails.getUserId();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        bankCard.setUserId(userId);

        this.saveOrUpdate(bankCard);
        return true;

    }

    @Override
    public Boolean consume(HttpServletRequest request, Long bankCardId, OrderDTO orderDTO)  {

        String orderToken=request.getHeader("orderToken");
        if(StringUtils.isNullOrEmpty(orderToken)){
            return false;
        }
        String orderNum;
        try {
            orderNum= JwtUtil.parseJWT(orderToken).getSubject();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("未找到token");
        }


        Boolean result=false;
        if(orderNum.equals(orderDTO.getOrderId())){  //若token与订单匹配
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

    @Override
    public Boolean recharge(Long bankCardId, BigDecimal price) {
        BankCard bankCard=  this.getById(bankCardId);

        if(!Objects.isNull(bankCardId)){
            bankCard.setAccount(bankCard.getAccount().add(price));
        }else {
            return false;
        }
        return true;
    }

    @Override
    public List<BankCard> listBankCart() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long  userId=userDetails.getUserId();

       return new LambdaQueryChainWrapper<>(bankCardMapper).eq(BankCard::getUserId,userId).isNull(BankCard::getDeletedAt).list();

    }

    @Override
    public void deleteBankCard(Long cardId) {
       BankCard bankCard= bankCardMapper.selectById(cardId);
       bankCard.setDeletedAt(NowTime.setNowTime());
       this.saveOrUpdate(bankCard);
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





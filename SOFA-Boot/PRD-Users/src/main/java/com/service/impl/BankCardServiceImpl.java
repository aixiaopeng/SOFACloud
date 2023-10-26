package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.BankCard;
import com.entity.vo.LoginUser;
import com.result.Result;
import com.service.BankCardService;
import com.mapper.BankCardMapper;
import com.service.ProductService;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public Boolean consume(Long bankCardId, BigDecimal price) {
        BankCard bankCard=  this.getById(bankCardId);

        if(!Objects.isNull(bankCardId)){
            if(bankCard.getAccount().compareTo(price)<0){
                return false;
            }else {
                bankCard.setAccount(bankCard.getAccount().subtract(price));
                this.updateById(bankCard);
            }
        }else {
            return false;
        }
        return true;
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
}





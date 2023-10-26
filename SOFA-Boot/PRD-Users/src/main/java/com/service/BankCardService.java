package com.service;

import com.entity.BankCard;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
* @author 15012
* @description 针对表【bank_card】的数据库操作Service
* @createDate 2023-10-22 21:33:45
*/
public interface BankCardService extends IService<BankCard> {
    Boolean addBankCard(BankCard bankCard);

    Boolean consume(Long bankCardId, BigDecimal price);

    Boolean recharge(Long bankCardId, BigDecimal price);

    List<BankCard> listBankCart();

    void deleteBankCard(Long cardId);
}

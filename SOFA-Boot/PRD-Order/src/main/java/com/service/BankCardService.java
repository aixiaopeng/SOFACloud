package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.BankCard;
import com.entity.dto.OrderDTO;

import java.math.BigDecimal;

/**
* @author 15012
* @description 针对表【bank_card】的数据库操作Service
* @createDate 2023-10-22 21:33:45
*/
public interface BankCardService extends IService<BankCard> {

    Boolean comsume(Long bankCardId, OrderDTO orderDTO);


}

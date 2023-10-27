package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.BankCard;
import com.entity.dto.OrderDTO;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public interface RPCBankCardService extends IService<BankCard> {
    Boolean consume(HttpServletRequest request, Long bankCardId, OrderDTO orderDTO);


}

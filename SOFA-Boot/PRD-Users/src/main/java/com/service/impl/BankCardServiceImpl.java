package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.BankCard;
import com.service.BankCardService;
import com.mapper.BankCardMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【bank_card】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class BankCardServiceImpl extends ServiceImpl<BankCardMapper, BankCard>
    implements BankCardService{

}





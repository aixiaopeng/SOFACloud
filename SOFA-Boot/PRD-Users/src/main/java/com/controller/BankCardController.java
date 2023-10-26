package com.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.entity.BankCard;
import com.result.Result;
import com.service.BankCardService;
import com.utils.NowTime;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/bankcard")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @PostMapping("/add")
    public Result addBankCard(@RequestBody BankCard bankCard){
       Boolean flag= bankCardService.addBankCard(bankCard);
        if(flag){
            return Result.ok("添加成功");
        }else {
            return Result.fail("添加失败");
        }
    }

    @DeleteMapping("/delete")
    public Result deleteBankCard(Long id){
        BankCard bankCard= bankCardService.getById(id);
        bankCard.setDeletedAt(NowTime.setNowTime());
        bankCardService.save(bankCard);
        return Result.ok("删除成功");
    }


    @GetMapping("/consume")
    public Result consume(@RequestParam Long bankCardId, @RequestParam BigDecimal price){
       Boolean flag=  bankCardService.consume(bankCardId,price);
        if(flag){
            return Result.ok("交易成功");
        }else {
            return Result.fail("余额不足");
        }

    }


    @GetMapping("/recharge")
    public Result recharge(@RequestParam Long bankCardId, @RequestParam BigDecimal price){
        bankCardService.recharge(bankCardId,price);
        return Result.ok("消费成功");
    }


    @GetMapping("/list")
    public Result listBankCard(){
        return  Result.ok(bankCardService.listBankCart());
    }



}

package com.controller;

import com.entity.vo.ShoppingCartVO;
import com.result.Result;
import com.service.QueryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/history")
public class QueryHistoryController {

    @Autowired
    private QueryHistoryService queryHistoryService;

    @GetMapping("/add")
    public Result addHistory(@RequestParam Long productId){
        queryHistoryService.addHistory(productId);
        return Result.ok("添加成功");
    }

    @GetMapping("/list")
    public Result listHistory(){
       List<ShoppingCartVO> shoppingCartVOS= queryHistoryService.listHistory();
       if(Objects.isNull(shoppingCartVOS)){
           return Result.fail("空空如也");
       }
        return Result.ok(shoppingCartVOS);
    }

    @DeleteMapping("/delete")
    public Result deleteHistory(@RequestParam Long productId){
        queryHistoryService.deleteHistory(productId);
        return Result.ok("删除成功");
    }
}

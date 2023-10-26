package com.controller;

import com.result.Result;
import com.service.QueryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

        return Result.ok(queryHistoryService.listHistory());
    }

    @DeleteMapping("/delete")
    public Result deleteHistory(@RequestParam Long productId){
        queryHistoryService.deleteHistory(productId);
        return Result.ok("删除成功");
    }
}

package com.controller;

import com.entity.Examine;
import com.result.Result;
import com.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examine")
public class ExamineController {
    @Autowired
    private ExamineService examineService;

    @PostMapping("/add")
    public Result add(@RequestBody Examine examine){
        return Result.ok(examineService.addExam(examine));
    }

    @GetMapping("/page")
    public Result page(int page,int pageSize){
        return Result.ok(examineService.ListManageProduct(page,pageSize));
    }
}

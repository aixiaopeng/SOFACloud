/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.controller;

import com.entity.Users;
import com.result.Result;
import com.service.impl.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestfulDemoController
 *
 * @author xunfang
 * @version RestfulDemoController.java, v 0.1 2023/10/13
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*")
public class UsersController {
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersServiceImpl userService;


    @GetMapping("/getPublic/{id}")
    public Result getPublic(@PathVariable Long id){
        return Result.ok(userService.getPublic(id));
    }

    @GetMapping("/getManager/{id}")
    public Result getManager(@PathVariable Long id){
        return Result.ok(userService.getManager(id));
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody Users user){
        userService.addUser(user);
        return Result.ok("添加成功");
    }


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('supervisor')")
    public Result list(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                             @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize,
                            @RequestParam(name = "isPublic", defaultValue = "1",required = false) int isPublic){
        return Result.ok(userService.list(page,pageSize,isPublic));
    }


    @PutMapping("/update")
    public Result update(@RequestBody Users user){
       Boolean flag= userService.updateUsers(user);
       if (flag==true){
           return Result.ok("更新成功");
       }else {
           return Result.fail("只能修改自己的账号！");
       }
    }
    @PostMapping("/status/0")
    public Result ban(@RequestParam List<Long> ids){
        userService.banUserByIds(ids);
        return Result.ok("修改成功");
    }
    @PostMapping("/status/1")
    public Result enable(@RequestParam List<Long> ids){
        userService.enableUserByIds(ids);
        return Result.ok("修改成功");
    }
    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        userService.delete(ids);
        return Result.ok("删除成功");
    }

}

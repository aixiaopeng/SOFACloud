/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.web;

import com.Impl.UsersServiceImpl;
import com.entity.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestfulDemoController
 *
 * @author xunfang
 * @version RestfulDemoController.java, v 0.1 2023/10/13
 */
@RestController
@RequestMapping("/user")
public class UsersController {
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersServiceImpl userService;
    @GetMapping
    public Users getUser(int id) {

       return userService.getById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "sb";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String adminTest(){
        return "管理员专属";
    }


}

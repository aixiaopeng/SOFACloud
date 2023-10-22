package com.controller;

import com.entity.vo.LoginVo;
import com.result.Result;
import com.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo)  {      //返回token值，使用jwt生成
        String token = loginService.login(loginVo);
        return Result.ok(token);
    }

    @RequestMapping("/logout")
    public Result logout(){
        loginService.logout();
        return Result.ok("退出成功");
    }

}

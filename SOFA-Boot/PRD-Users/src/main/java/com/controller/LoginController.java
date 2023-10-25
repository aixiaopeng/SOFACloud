package com.controller;

import com.entity.vo.LoginVo;
import com.result.Result;
import com.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo)  {      //返回token值，使用jwt生成
        String token=null;
        try {
            token = loginService.login(loginVo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("账号或密码错误");
        }
        return Result.ok(token);
    }

    @RequestMapping("/logout")
    public Result logout(){
        loginService.logout();
        return Result.ok("退出成功");
    }

}

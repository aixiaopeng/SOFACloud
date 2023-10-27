package com.controller;

import com.entity.vo.LoginVo;
import com.entity.vo.UserVO;
import com.result.Result;
import com.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")

public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo)  {      //返回token值，使用jwt生成
        UserVO userVO=null;
        try {
            userVO = loginService.login(loginVo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("账号或密码错误");
        }
        return Result.ok(userVO);
    }

    @RequestMapping("/logout")
    public Result logout(){
        loginService.logout();
        return Result.ok("退出成功");
    }

}

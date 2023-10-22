package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class testController {

    @Value("${config}")
    private String configInfo;

    @GetMapping("/test")
    public String test(){
        return "成功订单成功！";
    }


    @GetMapping("/nacos")
    public String nacosTest(){
        return "nacos:"+configInfo;
    }

}

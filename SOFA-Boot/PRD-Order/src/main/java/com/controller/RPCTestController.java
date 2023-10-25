package com.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import com.service.RPCTestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc")
public class RPCTestController {

//    @SofaReference(interfaceType = ProductTestService.class, jvmFirst = false,
//            binding = @SofaReferenceBinding(bindingType = "bolt"))
//    private ProductTestService productTestService;

    @SofaReference(interfaceType = RPCTestService.class, jvmFirst = false,
            binding = @SofaReferenceBinding(bindingType = "bolt"))
    private RPCTestService rpcTestService;


    @GetMapping("/test")
    public String sayClientAnnotation(String str) {
        return rpcTestService.test("这是订单调用");
    }
}

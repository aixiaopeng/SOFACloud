package com.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.service.ProductTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc")
public class RPCTestController {

    @SofaReference(interfaceType = ProductTestService.class, jvmFirst = false,
            binding = @SofaReferenceBinding(bindingType = "bolt"))
    private ProductTestService productTestService;


    @GetMapping("/test")
    public String sayClientAnnotation(String str) {
        return productTestService.RPCTest("用户PRC调用商品");
    }
}

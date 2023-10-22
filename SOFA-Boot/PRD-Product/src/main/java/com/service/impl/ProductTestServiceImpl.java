package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.service.ProductTestService;
import org.springframework.stereotype.Service;

@SofaService(interfaceType = ProductTestService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
@Service
public class ProductTestServiceImpl implements ProductTestService {
    @Override
    public String RPCTest(String str) {
            return str;
    }
}

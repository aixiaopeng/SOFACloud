package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.service.RPCTestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@SofaService(interfaceType = RPCTestService.class, bindings = {
        @SofaServiceBinding(bindingType = "bolt")
})
public class RPCTestServiceImpl implements RPCTestService {

    @Value("${server.port}")
    private int port;

    @Override
    public String test(String str) {
        return "用户成功被调用"+str+port;
    }
}

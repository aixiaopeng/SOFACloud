package com;

import com.alipay.sofa.rpc.boot.runtime.param.BoltBindingParam;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan("com.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);


//        BoltBindingParam boltBindingParam = new BoltBindingParam();
//        boltBindingParam.setLoadBalancer("roundRobin");
    }
}

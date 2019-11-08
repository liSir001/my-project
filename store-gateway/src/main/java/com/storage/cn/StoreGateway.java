package com.storage.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description: 服务网关
 * @Auther: Lei Li
 * @Date: 2019/11/8 11:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class StoreGateway {
    public static void main(String[] args) {
        SpringApplication.run(StoreGateway.class, args);
    }
}

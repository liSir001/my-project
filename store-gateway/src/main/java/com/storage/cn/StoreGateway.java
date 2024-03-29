package com.storage.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description: 服务网关
 * @Auther: Lei Li
 * @Date: 2019/11/8 11:15
 * @Version 1.0
 */
@SpringCloudApplication
@EnableZuulProxy
public class StoreGateway {
    public static void main(String[] args) {
        SpringApplication.run(StoreGateway.class, args);
    }
}

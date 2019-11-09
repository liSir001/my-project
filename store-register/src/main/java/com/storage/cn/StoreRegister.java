package com.storage.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: eureka服务端
 * @Auther: Lei Li
 * @Date: 2019/11/8 10:42
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class StoreRegister {
    public static void main(String[] args) {
        SpringApplication.run(StoreRegister.class, args);
    }
}

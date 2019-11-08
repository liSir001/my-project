package com.storage.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: eureka客户端
 * @Auther: liSir
 * @Date: 2019/11/8 10:50
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClient {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient.class, args);
    }
}

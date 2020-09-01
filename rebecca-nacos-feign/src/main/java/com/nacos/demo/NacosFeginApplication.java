package com.nacos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/18 16:13at
 * 4
 */
@SpringBootApplication
@EnableFeignClients
public class NacosFeginApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosFeginApplication.class, args);
    }
}

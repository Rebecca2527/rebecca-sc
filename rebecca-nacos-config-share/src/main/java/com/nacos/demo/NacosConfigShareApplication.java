package com.nacos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/19 14:19
 * 4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigShareApplication.class, args);
    }
}

package com.sentinel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/19 16:00
 * 4   使用nacos做sentinel规则的持久化
 * 5   通过配置其持久化可以做到同步，这里不表
 * 6   学习资料：
 * 7    blog.didispace.com/spring-cloud-alibaba-sentinel-2-4/   (同步内容)
 * 8    http://blog.didispace.com/spring-cloud-alibaba-sentinel-2-1/
 */
@SpringBootApplication
public class SentinelSaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelSaveApplication.class, args);
    }
}

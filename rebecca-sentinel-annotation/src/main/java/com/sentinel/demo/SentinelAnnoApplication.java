package com.sentinel.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/20 10:57
 * 4  @sentinelResource注解 ： 可用于限流及Hystrix类似的熔断降级策略
 * 5  学习资料： http://blog.didispace.com/spring-cloud-alibaba-sentinel-2-1/
 */
@SpringBootApplication
public class SentinelAnnoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelAnnoApplication.class, args);
    }

    @Bean //注解支持的配置bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}

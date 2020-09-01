package com.swagger.demo;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/21 15:11
 * 4
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class SwaggerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerAApplication.class, args);
    }
}

package com.nacos.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/19 11:10
 * 4
 */
@RestController
@RefreshScope//使当前类下的配置支持动态更新
public class ConfigDemo {

    @Value("${nacos.config}")
    private String string;

    @GetMapping("getValue")
    public String getValue() {
        return string;
    }
}

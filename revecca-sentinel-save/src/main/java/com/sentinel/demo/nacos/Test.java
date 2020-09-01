package com.sentinel.demo.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/19 16:32
 * 4
 */
@Slf4j
@RestController
public class Test {

    @GetMapping("/hello")
    public String hello() {
        return "hello sentinel in nacos .";
    }
}

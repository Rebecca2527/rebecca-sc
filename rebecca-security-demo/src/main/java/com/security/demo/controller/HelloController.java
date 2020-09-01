package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/24 16:32
 * 4
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public  String hello() {
        return "hello";
    }
}


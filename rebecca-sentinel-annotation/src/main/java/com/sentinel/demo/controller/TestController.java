package com.sentinel.demo.controller;

import com.sentinel.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/20 13:40
 * 4
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        testService.doSomeThing("hello" + new Date());
        return "Testcontroller hello .";
    }

    @GetMapping("/block")
    public String block() {
        testService.throwDemo("hi: " + new Date());
        return "Testcontroller block hello .";
    }

    @GetMapping("/hello2")
    public String hello2() {
        testService.doSomeThing2("hello2" + new Date());
        return "Testcontroller hello2 .";
    }

    @GetMapping("/fallback")
    public String fallback() {
        testService.fallBackDemo("fallback: " + new Date());
        return "Testcontroller fallback .";
    }
}

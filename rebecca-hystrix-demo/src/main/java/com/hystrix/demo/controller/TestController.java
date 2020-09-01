package com.hystrix.demo.controller;

import com.hystrix.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/26 15:19
 * 4
 */
@RestController
public class TestController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String test() throws InterruptedException {
        //Thread.sleep(5000L);
        //String services = "Services: " + discoveryClient.getServices();
        return consumerService.consumer();
    }

}

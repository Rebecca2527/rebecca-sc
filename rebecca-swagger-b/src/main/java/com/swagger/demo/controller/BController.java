package com.swagger.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/21 15:44
 * 4
 */
@RestController
public class BController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/service-b")
    public String cb() {
        String service = "Service: " + discoveryClient.getServices();
        System.err.print(service);
        return service;
    }
}

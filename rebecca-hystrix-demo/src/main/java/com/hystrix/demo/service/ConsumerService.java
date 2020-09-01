package com.hystrix.demo.service;

import com.hystrix.demo.client.TestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/26 15:12
 * 4
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TestClient testClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return testClient.getHello();
    }

    public String fallback() {
        return "fallback";
    }
}

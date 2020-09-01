package com.nacos.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 使用restTemp+Ribbon调用(有问题)
 */
@RestController
@EnableDiscoveryClient
public class RtemplateDemo {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced //开启rt负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String test1() {
        return restTemplate.getForObject("http://nacos-provide/helloNacos", String.class);
    }
}

package com.nacos.demo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/18 16:16
 * 4
 */
@RestController
@EnableDiscoveryClient
public class FeignDemo {

    @Autowired
    private RemoteClient remoteClient;

    @GetMapping("feign")
    public String fegin() {
        return remoteClient.helloNacos();
    }

    @GetMapping("zuulDemo")
    public String zuulDemo() {
        return "zuul test ";
    }

}

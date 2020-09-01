package com.nacos.demo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class ClientDemo {

    @Value("${server.port}")
    private String port;  // 通过端口号查看是否轮询

    @GetMapping("helloNacos")
    public String helloNacos(){
        return "你好，nacos! : " + port;
    }
}

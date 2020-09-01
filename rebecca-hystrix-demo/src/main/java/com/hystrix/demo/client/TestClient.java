package com.hystrix.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/27 16:13
 * 4
 */
@FeignClient(name = "provide", url = "127.0.0.1:9527")
public interface TestClient {

    @GetMapping("/helloNacos")
    String getHello();
}

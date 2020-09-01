package com.nacos.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/18 16:19
 * 4
 */
@FeignClient(name = "rebecca-nacos-provide", fallback = RemoteHystrix.class)
@Primary
public interface RemoteClient {

    @GetMapping("/helloNacos")
    String helloNacos();
}

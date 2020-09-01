package com.nacos.demo.feign;

import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/18 16:19
 * 4
 */
@Component
public class RemoteHystrix implements RemoteClient {

    public String helloNacos() {
        return "fallback test";
    }
}

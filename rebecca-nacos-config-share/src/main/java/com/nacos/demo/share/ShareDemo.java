package com.nacos.demo.share;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/19 14:22
 * 4    12为同一group 34不同
 */
@RestController
@RefreshScope
public class ShareDemo {

    @Value("${name.share}")
    private String share;



    @Value("${share.config1}")
    private String shareConfig1;

    @Value("${share.config2}")
    private String shareConfig2;

    @RequestMapping("/getValue")
    public String getValue() {
        return share;
    }

    @RequestMapping("/getShare1")
    public String getShare1() {
        return shareConfig1;
    }

    @RequestMapping("/getShare2")
    public String getShare2() {
        return shareConfig2;
    }

    @Value("${share.config3}")  //3，4不在同一group下
    private String shareConfig3;

    @Value("${share.config4}")
    private String shareConfig4;


    @RequestMapping("/getShare3")
    public String getShare3() {
        return shareConfig3;
    }

    @RequestMapping("/getShare4")
    public String getShare4() {
        return shareConfig4;
    }

}

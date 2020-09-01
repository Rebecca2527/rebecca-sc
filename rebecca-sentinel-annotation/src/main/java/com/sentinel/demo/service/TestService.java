package com.sentinel.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/20 11:07
 * 4
 */
@Slf4j
@Service
public class TestService {

    /*
        降流限制报错日志：com.alibaba.csp.sentinel.slots.block.flow.FlowException: null
     */
    @SentinelResource(value = "doSomeThing") //对该方法进行保护 可在sentinel设置降流等操作
    public void doSomeThing(String str) {
        log.info(str); //要记得装lombok插件
    }

    /*
        可通过blockHandler参数指定处理方法，避免如上一个方法显示在前端的生硬异常，
        与Hysyrix的fallback类似
        blockHandler要求：
            返回值类型必须与原函数返回值类型一致；
            方法参数列表需要和原函数一致，或者可以额外多一个
     */
    @SentinelResource(value = "throwDemo", blockHandler = "exceptionHandler")
    public void throwDemo(String str) {
        //log.info(str);
    }

    //处理方法
    public void exceptionHandler(String str, BlockException blockException) {
        log.info("blockHandler: " + str, blockException);
    }

    /*
       降级报错日志：com.alibaba.csp.sentinel.slots.block.degrade.DegradeException: null
     */
    @SentinelResource(value = "doSomeThing2")
    public void doSomeThing2(String str) {
        log.info(str);
        throw new RuntimeException("发生异常 .");
    }

    /*
        可通过fallback参数指定处理方法，与Hysyrix的fallback类似
        fallback要求：
            返回值类型必须与原函数返回值类型一致；
            方法参数列表需要和原函数一致，或者可以额外多一个
    */
    @SentinelResource(value = "fallBackDemo", fallback = "fallbackHandler")
    public void fallBackDemo(String str) {
        log.info(str);
        throw new RuntimeException("发生异常 .");
    }

    //熔断降级的处理方法，当满足一定条件后则会直接调用该方法
    public void fallbackHandler(String str) {
        log.error("fallbackHandler：" + str);
    }
}

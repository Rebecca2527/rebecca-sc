package rebecca.hystrix.simple.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rebecca.hystrix.simple.config.MyHystrixMergeService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/9/1 17:55
 * 4    注解请求合并
 */
@RestController
public class TestController {
    @Autowired
    private MyHystrixMergeService myHystrixMergeService;

    @RequestMapping("/merge")
    public void merge() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        Future<String> future1 = myHystrixMergeService.merge(1);
        Future<String> future2 = myHystrixMergeService.merge(2);
        Future<String> future3 = myHystrixMergeService.merge(3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}

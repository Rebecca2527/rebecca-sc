package com.zuul.demo;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.zuul.demo.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/20 15:57
 * 4   zuul 路由 过滤器  /整合swagger汇总api
 * 5   默认路由是每个服务在nacos上配置的服务名称 eg:127.0.0.1:xxxx/servername/method
 * 6   资料：
 * 7    blog.didispace.com/spring-cloud-starter-dalston-6-1/ 不过这里我还是继续用的nacos
 * 8    http://blog.didispace.com/spring-cloud-starter-dalston-6-3/  (过滤器)
 * 9    blog.didispace.com/Spring-Cloud-Zuul-use-Swagger-API-doc/   整合Swagger
 */
@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2Doc
public class ZuulApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiApplication.class, args);
    }

    /*
        在实现了自定义过滤器之后，它并不会直接生效
        我们还需要为其创建具体的Bean才能启动该过滤器
        比如，在应用主类中增加如下内容
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}

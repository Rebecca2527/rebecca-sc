package com.swagger.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/21 10:30
 * 4    swagger
 * 5    http://blog.didispace.com/springbootswagger2/
 */
@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}

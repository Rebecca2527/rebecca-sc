package com.swagger.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/21 10:31
 * 4    swagger2的配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    //用来创建API的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("请关注：Rebecca2527")
                .termsOfServiceUrl("https://mp.weixin.qq.com/s/0sDU_j1B6o12L52UxwQktQ")
                .contact("大熊熊熊熊")
                .version("1.0")
                .build();
    }
}

package com.zuul.demo.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/21 11:01
 * 4
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    public List<SwaggerResource> get() {
        List resources = new ArrayList();
        // application name/v2/api-docs
        resources.add(swaggerResource("rebecca-swagger-a", "/rebecca-swagger-a/v2/api-docs", "2.0"));
        resources.add(swaggerResource("rebecca-swagger-b", "/rebecca-swagger-b/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}

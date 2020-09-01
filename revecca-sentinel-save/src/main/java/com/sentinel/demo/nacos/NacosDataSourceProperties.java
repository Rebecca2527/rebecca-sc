package com.sentinel.demo.nacos;

import org.springframework.cloud.alibaba.sentinel.datasource.config.AbstractDataSourceProperties;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/19 16:24
 * 4 nacos存储配置
 */
public class NacosDataSourceProperties extends AbstractDataSourceProperties {

    public NacosDataSourceProperties(String factoryBeanName) {
        super(factoryBeanName);
    }

    private String serverAddr;
    private String groupId;
    private String dataId;

    // commercialized usage

    private String endpoint;
    private String namespace;
    private String accessKey;
    private String secretKey;
}

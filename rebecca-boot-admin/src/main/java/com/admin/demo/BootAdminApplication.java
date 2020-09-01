package com.admin.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/27 13:24
 * 4   Spring Boot Admin
 */
@SpringBootApplication
@EnableAdminServer //开启admin server功能
public class BootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootAdminApplication.class, args);
    }
}

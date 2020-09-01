package rebecca.nacos.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/27 14:16
 * 4    spring boot admin 与 nacos整合
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class NacosAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosAdminApplication.class, args);
    }
}

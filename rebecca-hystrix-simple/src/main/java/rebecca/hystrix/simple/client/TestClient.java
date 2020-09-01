package rebecca.hystrix.simple.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/9/1 17:58
 * 4
 */
@FeignClient("rebecca-nacos-provide")
public interface TestClient {

    @GetMapping("helloNacos")
    public String helloNacos();
}

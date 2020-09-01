package rebecca.hystrix.simple.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rebecca.hystrix.simple.client.TestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/9/1 17:41
 * 4    使用注解的方式进行请求合并
 */
@Service
public class MyHystrixMergeService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private TestClient testClient;


    /**
     * 指定批处理的方法，设置合并200ms之内的请求
     * @param id
     * @return
     */
    @HystrixCollapser(batchMethod = "getMerge", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "200")})
    public Future<String> merge(Integer id) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public List<String> getMerge(List<Integer> ids) {
        System.out.println("合并的请求：" + ids.toString());
        String[] result = restTemplate.getForEntity("http://eureka-client/merge?id={1}", String[].class, StringUtils.join(ids, ",")).getBody();
        System.out.println("合并后的结果" + result);
        return Arrays.asList(result);
    }

    /**
     * 降级方法的参数，返回值类型，返回值数量要和上面的方法对应
     * @param ids
     * @return
     */
    public List<String> fallback(List<Integer> ids) {
        List<String> list = new ArrayList<>();
        list.add("请求合并失败-1");
        list.add("请求合并失败-2");
        list.add("请求合并失败-3");
        return list;
    }
}

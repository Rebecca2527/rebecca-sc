package rebecca.hystrix.simple.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/8/31 14:19
 * 4
 */
public class TestCommand extends HystrixCommand {

    protected TestCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    protected Object run() throws Exception {
        return null;
    }
}

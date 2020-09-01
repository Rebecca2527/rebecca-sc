package rebecca.hystrix.simple.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/9/1 14:16
 * 4   清除缓存
 */
public class ClearCacheHystrixCommand extends HystrixCommand<String> {

    private final String name;

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("MyKey");

    protected ClearCacheHystrixCommand(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroupKey"))
                .andCommandKey(GETTER_KEY));
        this.name = name;
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

    @Override
    protected String run() throws Exception {
        System.err.println("get data");
        return this.name + ": " + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "failed . ";
    }

    /**
     * 清除缓存的方法
     * @param name
     */
    public static  void flushCache(String name) {
        HystrixRequestCache
                .getInstance(GETTER_KEY,
                        HystrixConcurrencyStrategyDefault.getInstance())
                .clear(name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = new ClearCacheHystrixCommand("Bear").execute();
        System.out.println(result);
        //清除该key的缓存
        ClearCacheHystrixCommand.flushCache("Bear");
        Future<String> future = new ClearCacheHystrixCommand("Bear").queue();
        System.out.println(future.get());
    }
}

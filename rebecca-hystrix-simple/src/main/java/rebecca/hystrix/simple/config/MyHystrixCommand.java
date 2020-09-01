package rebecca.hystrix.simple.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/9/1 10:57
 * 4
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private final String name;

    /*
        通过构造函数设置一个 Groupkey
     */
    protected MyHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("MyBear"));
        //信号量隔离
        /*super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
                        .withMaxQueueSize(100).withMaximumSize(100)));*/
        //线程池隔离 (默认)
      /*  super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
                        .withMaxQueueSize(100).withMaximumSize(100))); */
        this.name = name;
    }

    /*
         具体的逻辑在 run 方法中
    */
    @Override
    protected String run() throws Exception {
/*
        try {
            // 模拟超时情况
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name + ": " + Thread.currentThread().getName();
*/

        System.err.println("get data");
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "faild . ";
    }

    /*
        在 Hystrix 中也为我们提供了方法级别的缓存。
        通过重写 getCacheKey 来判断是否返回缓存的数据，getCacheKey 可以根据参数来生成。
        这样同样的参数就可以都用到缓存了。
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //String result = new MyHystrixCommand("Bear").execute();
        //System.out.println(result);
        /*
            java.lang.InterruptedException: sleep interrupted
            sleep 被强行打断了
         */

        //异步
       // Future<String> future = new MyHystrixCommand("Cat").queue();
       // System.out.println(future.get());

        //初始化HystrixRequestContext
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = new MyHystrixCommand("Bear").execute();
        System.out.println(result);
        Future<String> future = new MyHystrixCommand("Bear").queue();
        System.out.println(future.get());
        context.shutdown();
    }
}

package rebecca.hystrix.simple.config;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2 * @Author: Rebecca
 * 3 * @Date: 2020/9/1 15:14
 * 4   合并请求 :   把重复的请求批量用一个HystrixCommand命令去执行
 * 5    优点：减少通信开销 缺点：请求延迟增加
 * 6    步骤：自定义类继承HystrixCollapser类，去合并请求，合并成一个集合，并且返回各自的结果
 * 7         继承HystrixCommand类，执行合并后的请求
 * 8         初始化HystrixRequestContext，创建自定义类，传递查询条件
 */
public class MyHystrixCollapses extends HystrixCollapser<List<String>, String, String> {

    private final String name;

    public MyHystrixCollapses(String name) {
        this.name = name;
    }

    /**
     * 获取参数
     * @return 每一个参数
     */
    @Override
    public String getRequestArgument() {
        return name;
    }

    /**
     * 创建HystrixCommond
     * @param collection 合并之后的参数
     * @return
     */
    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> collection) {
        //将请求参数封装到list集合中，并将封装过的参数传入HystrixCommand类，由HystrixCommand类执行
        return new BatchCommand(collection);
    }

    /**
     * 合并请求拿到结果，将请求结果按照请求顺序分发给各个请求
     * @param strings 返回的结果集
     * @param collection 合并的请求集
     */
    @Override
    protected void mapResponseToRequests(List<String> strings, Collection<CollapsedRequest<String, String>> collection) {
        AtomicInteger count = new AtomicInteger();
        //分别拿到每个请求的结果 并用该请求响应该结果（请求和结果对应）
        collection.forEach(c -> c.setResponse(strings.get(count.getAndIncrement())));
    }

    private static final class BatchCommand extends HystrixCommand<List<String>> {

        private final Collection<CollapsedRequest<String, String>> requests;

        protected BatchCommand(Collection<CollapsedRequest<String, String>> requests) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueForKey")));
            this.requests = requests;
        }

        @Override
        protected List<String> run() throws Exception {
            System.err.println("真正执行请求。。。");
            ArrayList<String> response = new ArrayList<String>();
            requests.forEach(r -> response.add("result : " + r.getArgument()));
            return response;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        //这里必须用异步请求，否则不会合并
        Future<String> f1 = new MyHystrixCollapses("Zhangxin").queue();
        Future<String> f2 = new MyHystrixCollapses("lisp").queue();
        System.err.println(f1.get() + " = " + f2.get());
        context.shutdown();
    }
}

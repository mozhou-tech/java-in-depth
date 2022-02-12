package com.tenstone.jdk.multithread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * Created by liuyuancheng on 2022/1/26  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class CompletableFutureDemo {

    /**
     * 异步执行静态方法
     *
     * @throws InterruptedException
     */
    @Test
    void supplyAsync() throws InterruptedException {
        final long begin = System.currentTimeMillis();
        // 创建异步执行任务:
        // CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            return 5 + Math.random() * 20;
        }).thenAccept((result) -> {
            // 如果执行成功:
            log.info("price: {} ,spend {}ms", result, System.currentTimeMillis() - begin);
        }).exceptionally((e) -> {
            // 如果执行异常:
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    @Test
    void callback() throws InterruptedException {
        // 在cfFetch中回调的内部任务
        CompletableFuture.supplyAsync(() -> {
            // 返回code
            return queryCode("中国石油");
        }).thenApplyAsync((code) -> {
            // 串行执行，获取价格
            return fetchPrice(code);
        }).thenAccept((result) -> {
            // cfFetch成功后打印结果:
            log.info("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        log.info("query code for name {}", name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        log.info("fetchPrice for code {}", code);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    /**
     * 两个任务同时执行，只要完成一个即可
     * @throws InterruptedException
     */
    @Test
    void parallelCallBack() throws InterruptedException {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        //===========================================================================================

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163)
                .thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

}

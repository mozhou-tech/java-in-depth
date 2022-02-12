package com.tenstone.jdk.multithread;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * Created by liuyuancheng on 2022/2/12  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class FutureDemo {


    @Test
    void future() throws ExecutionException, InterruptedException {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ExecutorService executor = new ThreadPoolExecutor(4, 4, 1000,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory());
        // 定义任务:
        Callable<String> task = new CallableTask();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);
        final Future<?> future1 = executor.submit(new RunnableTask());
        // 从Future获取异步执行返回的结果(可能阻塞)
        stopWatch.stop();
        log.info("runnable task result {}, task is done {}", future1.get(),future1.isDone());
        log.info("callable task result {} ,spend time {}ms", future.get(), stopWatch.getTime());
    }

    static class RunnableTask implements Runnable {

        public String result;

        @Override
        public void run() {
            this.result = longTimeCalculation();
        }
    }

    static class CallableTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return longTimeCalculation();
        }

    }

    public static String longTimeCalculation() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello future!";
    }
}

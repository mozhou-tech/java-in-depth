package com.tenstone.jdk.threadpool;

import com.crazymakercircle.util.ShutdownHookThread;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.crazymakercircle.util.ThreadUtil.*;

@Slf4j

//懒汉式单例创建线程池：用于混合型任务
public class MixedTargetThreadPoolLazyHolder {
    //首先从环境变量 mixed.thread.amount 中获取预先配置的线程数
    //如果没有对 mixed.thread.amount 做配置，则使用常量 MIXED_MAX 作为线程数
    private static final int max = (null != System.getProperty(MIXED_THREAD_AMOUNT)) ?
            Integer.parseInt(System.getProperty(MIXED_THREAD_AMOUNT)) : MIXED_MAX;
    //线程池： 用于混合型任务
    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            max,
            max,
            KEEP_ALIVE_SECONDS,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue(QUEUE_SIZE),
            new CustomThreadFactory("mixed"));


    public static ThreadPoolExecutor getInnerExecutor() {
        return EXECUTOR;
    }

    static {

        log.info("线程池已经初始化");


        EXECUTOR.allowCoreThreadTimeOut(true);
        //JVM关闭时的钩子函数
        Runtime.getRuntime().addShutdownHook(new ShutdownHookThread("混合型任务线程池", new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                //优雅关闭线程池
                shutdownThreadPoolGracefully(EXECUTOR);
                return null;
            }
        }));
    }
}

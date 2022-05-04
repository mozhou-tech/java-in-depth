package com.tenstone.jdk.multithread;

import com.tenstone.jdk.util.Print;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2022/5/2  <br/>
 *
 * @author liuyuancheng
 */
public class ThreadFactoryDemo {
    //一个简单的线程工厂
    static class SimpleThreadFactory implements ThreadFactory {
        static AtomicInteger threadNo = new AtomicInteger(1); //实现其唯一的创建线程方法

        @Override
        public Thread newThread(Runnable target) {
            String threadName = "simpleThread-" + threadNo.get();
            Print.tco("创建一条线程，名称为:" + threadName);
            threadNo.incrementAndGet(); //设置线程名称，和异步执行目标
            Thread thread = new Thread(target, threadName); //设置为守护线程
            thread.setDaemon(true);
            return thread;
        }
    }

    public static void main(String[] args) {
        final SimpleThreadFactory factory = new SimpleThreadFactory();
        for (int i = 0; i < 10; i++) {
            factory.newThread(() -> {
                for (int j = 0; j < 100; j++) {

                }
            });
        }

    }

}

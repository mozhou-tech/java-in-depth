package com.tenstone.leet.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 * <p>
 * The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
 * More precisely that means, that every read of a volatile variable will be read from the computer's main memory,
 * and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache.
 */
@Slf4j
public class VolatileDemo {

    private static Integer sychronizedCount = 0;

    private static int volatileCount = 0;

    private final static AtomicInteger atomicCount = new AtomicInteger(0);

    /**
     * 累加器
     */
    private static class Incrementor extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                // 为什么锁对象没有用？锁static变量有什么效果？
                synchronized (Incrementor.class) {
                    sychronizedCount++;
                }
                volatileCount = volatileCount + 1;
                atomicCount.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动3个线程，对volatileCount和atomicCount进行累加
        new Incrementor().start();
        new Incrementor().start();
        new Incrementor().start();
        // 等待10毫秒
        Thread.sleep(100);
        System.out.println("3个线程，累计遍历10000次");
        System.out.println("sychronized变量（类锁）: " + sychronizedCount+ " (需要加类锁，对象锁无效)");
        System.out.println("volatile变量: " + volatileCount + " (原子性没有得到保证，单线程不会出现累加结果不一致的问题)");
        System.out.println("atomic变量: " + atomicCount);
    }
}

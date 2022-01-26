package com.tenstone.juc.locks;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 * 使用ReadWriteLock可以提高读取效率：
 * ReadWriteLock只允许一个线程写入；
 * ReadWriteLock允许多个线程在没有写入时同时读取；
 * ReadWriteLock适合读多写少的场景。
 */
@Slf4j
public class ReentrantReadWriteLockDemo {

    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();

    private final Lock rlock = rwlock.readLock();

    private final Lock wlock = rwlock.writeLock();

    private int[] counts = new int[11];

    private AtomicInteger sum = new AtomicInteger(0);

    /**
     * 递增
     *
     * @param index
     */
    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    /**
     * 支持多个线程同时读
     *
     * @return
     */
    public int get(int offset) {
        rlock.lock(); // 加读锁
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return counts[offset];
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }

    static class RandomReadThread implements Runnable {

        private ReentrantReadWriteLockDemo demo;

        public RandomReadThread(ReentrantReadWriteLockDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            int offset = RandomUtils.nextInt(0, 11);
            final int value = this.demo.get(offset);
            log.info("index {}->{} (get)", offset, value);
        }
    }

    static class RandomWriteThread implements Runnable {

        private ReentrantReadWriteLockDemo demo;

        public RandomWriteThread(ReentrantReadWriteLockDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            int offset = RandomUtils.nextInt(0, 11);
            this.demo.inc(offset);
            this.demo.sum.incrementAndGet();
            log.info("index {}->{} (inc)", offset, demo.get(offset));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                2, 3, TimeUnit.MINUTES, queue,
                Executors.defaultThreadFactory());

        final ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        for (int i = 0; i < 100; i++) {
            // execute 只能提交Runnable，能抛出异常
            pool.execute(new RandomReadThread(demo));
            // submit 可以提交Runnable和Callable，不能抛出异常
            pool.submit(new RandomWriteThread(demo));
            log.info("active thread count {}, queue size {}", pool.getActiveCount(), queue.size());
        }
        Thread.sleep(3000);
        log.info("sum :{}", demo.sum.get());
        // 等待10秒，关闭线程池
        final boolean termination = pool.awaitTermination(5, TimeUnit.MINUTES);
        if (termination) {
            log.info("线程池退出成功");
        }
    }
}

package com.tenstone.juc.locks;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.Map;
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
 * ReadWriteLock适合读多写少的场景（多线程读，单线程写）。
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
        try {
            wlock.lock(); // 加写锁
            log.info("获得写锁");
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
            log.info("释放写锁");
        }
    }

    /**
     * 支持多个线程同时读
     *
     * @return
     */
    public int[] get() {
        try {
            rlock.lock(); // 加读锁
            log.info("获取读锁");
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
            log.info("释放读锁");
        }
    }

    static class RandomReadThread implements Runnable {

        private ReentrantReadWriteLockDemo demo;

        public RandomReadThread(ReentrantReadWriteLockDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            final int[] value = this.demo.get();
            Map<Integer, Integer> logging = Maps.newHashMap();
            for (int i = 0; i < value.length; i++) {
                logging.put(i, value[i]);
            }
            log.info("list -> {} (get)", logging);
        }
    }

    static class RandomWriteThread implements Callable<Integer> {

        private ReentrantReadWriteLockDemo demo;

        public RandomWriteThread(ReentrantReadWriteLockDemo demo) {
            this.demo = demo;
        }

        @Override
        public Integer call() throws Exception {
            int offset = RandomUtils.nextInt(0, 11);
            this.demo.inc(offset);
            this.demo.sum.incrementAndGet();
            log.info("index {}->{} (inc)", offset, demo.counts[offset]);
            return demo.counts[offset];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 3, TimeUnit.MINUTES,
                queue, Executors.defaultThreadFactory());

        final ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        for (int i = 0; i < 100; i++) {
            // execute 只能提交Runnable，能抛出异常
            pool.execute(new RandomReadThread(demo));
            // submit 可以提交Runnable和Callable，不能抛出异常
            pool.submit(new RandomWriteThread(demo));
        }
        Thread.sleep(3000);
        log.info("sum :{}", demo.sum.get());
        // 等待10秒，关闭线程池
        final boolean termination = pool.awaitTermination(5, TimeUnit.MINUTES);
        // 读锁是共享锁，写锁是独占锁（共享一把锁）
        // 因此读锁，可以同时被多个线程获得，因此出现读可以连续打印两条

        if (termination) {
            log.info("线程池退出成功");
        }
    }
}

package com.tenstone.jdk.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 */
@Slf4j
public class ReentrantLockDemo {
    private ReentrantLock lock = null;


    public ReentrantLockDemo() {
        // 创建一个自由竞争的可重入锁
        lock = new ReentrantLock();
    }

    public static void main(String[] args) {

        ReentrantLockDemo tester = new ReentrantLockDemo();

        try {
            // 测试可重入，方法testReentry() 在同一线程中,可重复获取锁,执行获取锁后，显示信息的功能
            tester.testReentry();
            // 能执行到这里而不阻塞，表示锁可重入
            tester.testReentry();
            // 再次重入
            tester.testReentry();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放重入测试的锁，要按重入的数量解锁，否则其他线程无法获取该锁。
            log.info("remain lock count: {}", tester.getLock().getHoldCount());
            tester.getLock().unlock();
            tester.getLock().unlock();
            tester.getLock().unlock();
            log.info("remain lock count: {}", tester.getLock().getHoldCount());
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void testReentry() {
        lock.lock();

        Calendar now = Calendar.getInstance();

        System.out.println(now.getTime() + " " + Thread.currentThread().getName()
                + " get lock.");
    }
}

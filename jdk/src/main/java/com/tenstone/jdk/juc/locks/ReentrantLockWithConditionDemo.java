package com.tenstone.jdk.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 * 两个线程顺序打印1-9
 * a: 1、2、3
 * b: 4、5、6
 * c: 7/8/9
 */
@Slf4j
public class ReentrantLockWithConditionDemo {

    static class NumberWrapper {
        public int value = 1;
    }

    public static void main(String[] args) {
        //初始化可重入锁
        final Lock lock = new ReentrantLock();

        //第一个条件当屏幕上输出到3
        final Condition reachThreeCondition = lock.newCondition();
        //第二个条件当屏幕上输出到6
        final Condition reachSixCondition = lock.newCondition();

        //NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
        //注意这里不要用Integer, Integer 是不可变对象
        final NumberWrapper num = new NumberWrapper();
        //初始化A线程
        Thread threadA = new Thread(() -> {
            // 需要先获得锁，防止其它线程访问
            lock.lock();
            try {
                //A线程先输出前3个数
                while (num.value <= 3) {
                    log.info("thread a: {}", num.value);
                    num.value++;
                }
                //输出到3时要signal，告诉B线程可以争夺锁了
                reachThreeCondition.signal();
            } finally {
                // 释放锁，让线程B抢占
                lock.unlock();
            }
            // 等待线程B释放锁后获得锁
            lock.lock();
            try {
                //等待输出6的条件
                reachSixCondition.await();
                //输出剩余数字
                while (num.value <= 9) {
                    log.info("thread a: {}", num.value);
                    num.value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                while (num.value <= 3) {
                    //等待3输出完毕的信号
                    reachThreeCondition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            try {
                lock.lock();
                //已经收到信号，开始输出4，5，6
                while (num.value <= 6) {
                    log.info("thread b: {}", num.value);
                    num.value++;
                }
                //4，5，6输出完毕，告诉A线程6输出完了
                reachSixCondition.signal();
            } finally {
                lock.unlock();
            }
        });
        //启动两个线程
        threadB.start();
        threadA.start();
    }
}

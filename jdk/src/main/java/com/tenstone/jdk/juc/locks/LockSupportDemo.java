package com.tenstone.jdk.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 * LockSupport是一个线程阻塞工具类，所有的方法都是静态方法，可以让线程在任意位置阻塞，
 * 当然阻塞之后肯定得有唤醒的方法。
 *
 * NEW The thread has not yet started.
 * RUNNABLE The thread is executing in the JVM.
 * BLOCKED The thread is blocked waiting for a monitor lock.
 * WAITING The thread is waiting indefinitely for another thread to perform a particular action.
 * TIMED_WAITING The thread is waiting for another thread to perform an action for up to a specified waiting time.
 * TERMINATED The thread has exited.
 * @author liuyuancheng
 */
@Slf4j
public class LockSupportDemo {

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (LockSupportDemo.class) {
                log.info("current thread name: {}， the status is {}", getName(), getState());
                // 两个线程都会被暂停  线程状态：BLOCKED
                LockSupport.park();
                log.info("current thread name: {}， the status is {}", getName(), getState());
                if (Thread.currentThread().isInterrupted()) {
                    log.info("interrupted thread name: {}", getName());
                }
                log.info("thread named {} is continuing", getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        // t1被中断时 线程状态：Terminate
        t1.interrupt();
        // 唤醒t2
        LockSupport.unpark(t2);
        log.info("t1 thread state : {}",t1.getState());
        log.info("t2 thread state : {}",t2.getState());
        // 等待线程运行结束
        t1.join();
        t2.join();
    }
}

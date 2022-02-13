package com.tenstone.jdk.multithread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 * <p>
 * ThreadLocal相当于给每个线程都开辟了一个独立的存储空间，各个线程的ThreadLocal关联的实例互不干扰。
 * 特别注意ThreadLocal一定要在finally中清除：
 */
@Slf4j
public class ThreadLocalDemo {


    @Test
    void printThreadName() {
        log.info("start main... 主线程");
        // Thread 是Runnable的实现
        new Thread(() -> {
            log.info("run task... {}", Thread.currentThread().getName());
        }).start();
        new Thread(() -> {
            log.info("print... {}", Thread.currentThread().getName());
        }).start();
        log.info("end main. {}", Thread.currentThread().getName());
    }

    @Test
    void holdDifferentContext() throws InterruptedException {
        UserTask userTaskHello = new UserTask("hello");
        UserTask userTaskWorld = new UserTask("world");
        userTaskHello.start();
        userTaskWorld.start();
        userTaskHello.join();
        userTaskWorld.join();
    }

    static class UserTask extends Thread {

        private UserContext userContext;

        private String username;

        private UserTask() {
        }

        public UserTask(String username) {
            this.username = username;
        }

        @Override
        public void run() {
            userContext = new UserContext(username);
            log.info("username: {}",userContext.currentUser());
        }

    }


    static class UserContext implements AutoCloseable {

        private final ThreadLocal<String> ctx = new ThreadLocal<>();

        public UserContext(String user) {
            ctx.set(user);
        }

        public String currentUser() {
            return ctx.get();
        }

        @Override
        public void close() {
            ctx.remove();
        }
    }


}

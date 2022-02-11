package com.tenstone.jdk.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * Created by liuyuancheng on 2022/1/28  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class ThreadJoinDemo {

    static class TaskDemo extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    log.info("task-demo : {}", new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final TaskDemo taskDemo = new TaskDemo();
        taskDemo.start();
        try {
            taskDemo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

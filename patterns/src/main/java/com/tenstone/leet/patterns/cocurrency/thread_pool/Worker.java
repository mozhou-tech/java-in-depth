package com.tenstone.leet.patterns.cocurrency.thread_pool;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/17  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class Worker implements Runnable {

    public Worker(Task task) {
        this.task = task;
    }

    private Task task;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        log.info("{} processing {}", Thread.currentThread().getName(), task.toString());
        try {
            Thread.sleep(task.getTimeMs());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

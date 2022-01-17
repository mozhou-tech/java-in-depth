package com.tenstone.leet.patterns.cocurrency.active_object;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by liuyuancheng on 2022/1/17  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public abstract class ActiveCreature {

    private BlockingQueue<Runnable> requests;

    private String name;

    private Thread thread;

    public ActiveCreature(String name) {
        this.name = name;
        // 阻塞队列
        this.requests = new LinkedBlockingQueue<>();
        // 创建一个线程，处理requests中的
        thread = new Thread(() -> {
            while (true) {
                try {
                    // 如果take不到，会被阻塞，知道下一个元素到来
                    requests.take().run();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        });
        this.thread.start();
    }


    public void eat() throws InterruptedException {
        requests.put(() -> {
            log.info("{} is eating!", name);
            log.info("{} has finished eating!", name);
        });
    }

    public  void roam() throws InterruptedException {
        requests.put(() -> log.info("{} has started to roam the wastelands",name));
    }
}

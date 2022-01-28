package com.tenstone.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2022/1/28  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(5);

    static AtomicInteger value = new AtomicInteger();

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 11; i++) {
            final Thread thread = new Thread(() -> {
                try {
                    semaphore.acquire();
                    log.info("value {}",value.incrementAndGet());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
            thread.start();
        }
    }
}

package com.tenstone.juc.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liuyuancheng on 2022/1/27  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class CountDownLatchDemo {

    static class Timer extends Thread {

        private int t = 0;

        private CountDownLatch latch;

        public Timer(int t, CountDownLatch latch) {
            this.t = t;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(this.t * 1000L);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        log.info("latch count : {}", latch.getCount());
        new Timer(1, latch).start();
        Thread.sleep(1300);
        log.info("latch count : {}", latch.getCount());
        new Timer(1, latch).start();
        Thread.sleep(1300);
        log.info("latch count : {}",latch.getCount());
        latch.await();
    }
}

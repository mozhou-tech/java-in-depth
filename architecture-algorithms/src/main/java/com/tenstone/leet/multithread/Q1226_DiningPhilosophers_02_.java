package com.tenstone.leet.multithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 * @TODO not pass
 */
@Slf4j
public class Q1226_DiningPhilosophers_02_ {
    public static class PickLeftFork implements Runnable {

        @Override
        public void run() {
            log.info(this.getClass().getSimpleName());
        }
    }

    public static class PickRightFork implements Runnable {

        @Override
        public void run() {
            log.info(this.getClass().getSimpleName());
        }
    }

    public static class PutLeftFork implements Runnable {

        @Override
        public void run() {
            log.info(this.getClass().getSimpleName());
        }
    }

    public static class PutRightFork implements Runnable {

        @Override
        public void run() {
            log.info(this.getClass().getSimpleName());
        }
    }

    public static class Eat implements Runnable {

        @Override
        public void run() {
            log.info(this.getClass().getSimpleName());
        }
    }

    static class DiningPhilosophers {

        //一个互斥信号量用于临界资源的互斥访问
        private Semaphore mutex;
        //5个同步信号量用于哲学家之间的同步访问
        private Semaphore[] sema;

        public DiningPhilosophers() {
            mutex = new Semaphore(1);
            sema = new Semaphore[]{
                    new Semaphore(1),
                    new Semaphore(1),
                    new Semaphore(1),
                    new Semaphore(1),
                    new Semaphore(1)
            };
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            //一个哲学家如果要拿起叉子就同时拿两个，因此这里是一个原子操作，需要用mutex信号量包起来，表示互斥
            mutex.acquire();
            //尝试获取左手边的叉子
            sema[philosopher].acquire();
            //尝试获取右手边的叉子
            sema[(philosopher + 1) % 5].acquire();

            pickLeftFork.run();
            pickRightFork.run();
            //我认为这句话应该放在这里。
            // mutex.release();

            //拿到叉子开始吃饭
            eat.run();

            //吃完饭放下叉子
            putLeftFork.run();
            sema[philosopher].release();
            putRightFork.run();
            sema[(philosopher + 1) % 5].release();
            mutex.release();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        int[] philosopherNums = new int[]{0, 1, 2, 3, 4};
        Thread[] philosophers = new Thread[5];
        for (int i = 0; i < philosopherNums.length; i++) {
            int finalI = i;
            philosophers[i] = new Thread("philosopher_" + finalI) {
                @Override
                public void run() {
                    try {
                        diningPhilosophers.wantsToEat(finalI, new PickLeftFork(), new PickRightFork(), new Eat(), new PutLeftFork(), new PutRightFork());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
        }
        for (Thread philosopher : philosophers) {
            philosopher.start();
        }
        Thread.sleep(2000);
    }
}

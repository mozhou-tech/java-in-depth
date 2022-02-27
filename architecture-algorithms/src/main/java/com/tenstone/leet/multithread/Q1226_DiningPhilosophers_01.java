package com.tenstone.leet.multithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class Q1226_DiningPhilosophers_01 {
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

        public DiningPhilosophers() {

        }
        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] philosophers = new int[]{0, 1, 2, 3, 4};
        final DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        for (int philosopher : philosophers) {
            log.info("philosopher {}",philosopher);
            diningPhilosophers.wantsToEat(philosopher, new PickLeftFork(), new PickRightFork(), new Eat(), new PutLeftFork(), new PutRightFork());
        }

    }
}

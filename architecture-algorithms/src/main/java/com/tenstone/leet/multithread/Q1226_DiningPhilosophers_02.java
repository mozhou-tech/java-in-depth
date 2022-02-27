package com.tenstone.leet.multithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 * @TODO not pass
 */
@Slf4j
public class Q1226_DiningPhilosophers_02 {
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

        private AtomicInteger turn = new AtomicInteger(0);

        private volatile int eatingGroupId = 0;

        private CopyOnWriteArrayList<Thread> park = new CopyOnWriteArrayList<>();

        private boolean canIEat(int philosopher) {
            return philosopher % 2 == eatingGroupId;
        }

        private void nextTurn() {
            eatingGroupId = turn.incrementAndGet() % 2;
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            final boolean canIEat = canIEat(philosopher);
            if (!canIEat) {
                park.add(Thread.currentThread());
                LockSupport.park();
                wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
            } else {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
                nextTurn();
                for (Thread thread : park) {
                    LockSupport.unpark(thread);
                }
            }
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

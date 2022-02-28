package com.tenstone.leet.multithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class Q1226_DiningPhilosophers_03_ {
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
        //定义Lock
        private ReentrantLock lock = new ReentrantLock();
        //定义Condition数组
        private Condition[] conditions = new Condition[5];
        //定义叉子是否被占用的标记
        private boolean[] forks = new boolean[5];

        public DiningPhilosophers() {
            //创建Condition对象
            for (int i = 0; i < 5; i++) {
                conditions[i] = lock.newCondition();
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            lock.lock();
            try {
                //定义哲学家左右叉子编号
                int leftFork = philosopher;
                int rightFork = (philosopher + 1) % 5;

                //左右两边任意一个叉子被占用，线程等待
                while (forks[leftFork] || forks[rightFork]) {
                    conditions[philosopher].await();
                }

                //占用叉子
                forks[leftFork] = true;
                forks[rightFork] = true;

                //吃面
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();

                //放下左边叉子
                putLeftFork.run();
                forks[leftFork] = false;
                conditions[leftFork].signal();
                //放下右边叉子
                putRightFork.run();
                forks[rightFork] = false;
                conditions[rightFork].signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] philosophers = new int[]{0, 1, 2, 3, 4};
        final DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        for (int philosopher : philosophers) {
            log.info("philosopher {}", philosopher);
            diningPhilosophers.wantsToEat(philosopher, new PickLeftFork(), new PickRightFork(), new Eat(), new PutLeftFork(), new PutRightFork());
        }

    }
}

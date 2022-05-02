package com.tenstone.jdk.multithread;

import com.tenstone.jdk.Print;

/**
 * Created by liuyuancheng on 2022/5/2  <br/>
 *
 * @author liuyuancheng
 */
public class InterruptDemo {
    public static final int SLEEP_GAP = 5000;//睡眠时长 public static final int MAX_TURN = 50;//睡眠次数

    static class SleepThread extends Thread {
        static int threadSeqNumber = 1;

        public SleepThread() {
            super("sleepThread-" + threadSeqNumber);
            threadSeqNumber++;
        }

        @Override
        public void run() {
            try {
                Print.tco(getName() + " 进入睡眠."); // 线程睡眠一会
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Print.tco(getName() + " 发生被异常打断.");
            }
            Print.tco(getName() + " 运行结束(中断后正常运行).");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new SleepThread();
        thread1.start();
        Thread thread2 = new SleepThread();
        thread2.start();
        Thread.sleep(2000);//主线程等待 2 秒
        thread1.interrupt(); //打断线程 1
        Thread.sleep(5000);//主线程等待 5 秒
        thread2.interrupt(); //打断线程2，此时线程2已经终止
        Thread.sleep(1000);//主线程等待 1 秒
        Print.tco("程序运行结束.");
    }
}


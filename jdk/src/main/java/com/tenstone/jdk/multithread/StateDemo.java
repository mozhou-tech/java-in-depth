package com.tenstone.jdk.multithread;

import com.tenstone.jdk.util.Print;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuancheng on 2022/5/2  <br/>
 *
 * @author liuyuancheng
 */
public class StateDemo {

    //每个线程执行的轮次
    public static final long MAX_TURN = 5;
    //线程编号
    static int threadSeqNumber = 0;
    //全局的静态线程列表
    static List<Thread> threadList = new ArrayList<>();

    //输出静态线程列表中，每个线程的状态
    private static void printThreadStatus() {
        for (Thread thread : threadList) {
            System.out.println(thread.getName() + " 状态为 " + thread.getState());
        }
    }

    //向全局的静态线程列表加入线程
    private static void addStatusThread(Thread thread) {
        threadList.add(thread);
    }

    static class StatusDemoThread extends Thread {
        public StatusDemoThread() {
            super("statusPrintThread" + (++threadSeqNumber)); //将自己加入到全局的静态线程列表 addStatusThread(this);
        }

        @SneakyThrows
        @Override
        public void run() {
            Print.cfo(getName() + ", 状态为" + getState());
            for (int turn = 0; turn < MAX_TURN; turn++) {
                //线程睡眠
                Thread.sleep(500);
                // 输出所有线程的状态
                printThreadStatus();
            }
            Print.cfo(getName() + "- 运行结束.");
        }
    }

    public static void main(String args[]) throws InterruptedException {
//将 main 线程加入全局列表
        addStatusThread(Thread.currentThread()); //新建三条线程，这些线程在构造器中会将自己加入全局列表
        Thread sThread1 = new StatusDemoThread();
        Print.cfo(sThread1.getName() + "- 状态为" + sThread1.getState());
        Thread sThread2 = new StatusDemoThread();
        Print.cfo(sThread2.getName() + "- 状态为" + sThread2.getState());
        Thread sThread3 = new StatusDemoThread();
        Print.cfo(sThread3.getName() + "- 状态为" + sThread3.getState());
        sThread1.start(); //启动第一个线程
        Thread.sleep(500);//等待 500ms 启动第二个线程
        sThread2.start();
        Thread.sleep(500);//等待 1000ms 启动第三个线程
        sThread3.start();
        Thread.sleep(100 * 1000);//睡眠 100 秒
    }

}

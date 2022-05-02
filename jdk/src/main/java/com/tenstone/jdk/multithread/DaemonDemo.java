package com.tenstone.jdk.multithread;

import com.tenstone.jdk.Print;

import static com.tenstone.jdk.multithread.StateDemo.MAX_TURN;

/**
 * Created by liuyuancheng on 2022/5/2  <br/>
 *
 * @author liuyuancheng
 */
public class DaemonDemo {
    public static final int SLEEP_GAP = 500; //每一轮的睡眠时长 public static final int MAX_TURN = 4; //用户线程执行轮次

    //守护线程实现类
    static class DaemonThread extends Thread {
        public DaemonThread() {
            super("daemonThread");
        }

        @Override
        public void run() {
            Print.synTco("--daemon 线程开始.");
            for (int i = 1; ; i++) //死循环
            {
                Print.synTco("--轮次:" + i);
                Print.synTco("--守护状态为:" + isDaemon()); // 线程睡眠一会，500 毫秒
                try {
                    Thread.sleep(SLEEP_GAP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        Thread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        //创建一条用户线程，执行 4 轮
        Thread userThread = new Thread(() -> {
            Print.synTco(">>用户线程开始.");
            for (int i = 1; i <= MAX_TURN; i++) {
                Print.synTco(">>轮次:" + i);
                Print.synTco(">>守护状态为:" + Thread.currentThread().isDaemon());
                try {
                    Thread.sleep(SLEEP_GAP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Print.synTco(">>用户线程结束.");
        }, "userThread");
        //启动用户线程
        userThread.start();
        Print.synTco(" 守护状态为:" + Thread.currentThread().isDaemon());
        Print.synTco(" 运行结束.");
    }
}

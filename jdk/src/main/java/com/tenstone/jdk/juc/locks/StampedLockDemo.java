package com.tenstone.jdk.juc.locks;

import java.util.Random;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 * https://www.cnblogs.com/tong-yuan/p/StampedLock.html
 * （1）StampedLock也是一种读写锁，它不是基于AQS实现的；
 * （2）StampedLock相较于ReentrantReadWriteLock多了一种乐观读的模式，以及读锁转化为写锁的方法；
 * （3）StampedLock的state存储的是版本号，确切地说是高24位存储的是版本号，写锁的释放会增加其版本号，读锁不会；
 * （4）StampedLock的低7位存储的读锁被获取的次数，第8位存储的是写锁被获取的次数；
 * （5）StampedLock不是可重入锁，因为只有第8位标识写锁被获取了，并不能重复获取；
 * （6）StampedLock中获取锁的过程使用了大量的自旋操作，对于短任务的执行会比较高效，长任务的执行会浪费大量CPU；
 * （7）StampedLock不能实现条件锁；
 */
public class StampedLockDemo {

    static class Point {
        private final StampedLock stampedLock = new StampedLock();

        private double x;
        private double y;

        public void move(double deltaX, double deltaY) {
            long stamp = stampedLock.writeLock(); // 获取写锁
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                stampedLock.unlockWrite(stamp); // 释放写锁
            }
        }

        public double distanceFromOrigin() {
            long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁
            // 注意下面两行代码不是原子操作
            // 假设x,y = (100,200)
            double currentX = x;
            // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
            double currentY = y;
            // 此处已读取到y，如果没有写入，读取是正确的(100,200)
            // 如果有写入，读取是错误的(100,400)
            if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
                stamp = stampedLock.readLock(); // 获取一个悲观读锁
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    stampedLock.unlockRead(stamp); // 释放悲观读锁
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }
    }

    public static void main(String[] args) {
        final Point point = new Point();
        for (;;) {
            point.move(new Random().nextDouble(),new Random().nextDouble());
            System.out.println(point.distanceFromOrigin());
        }
    }
}

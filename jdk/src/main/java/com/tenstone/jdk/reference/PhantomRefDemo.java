package com.tenstone.jdk.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 * 在NIO中，就运用了虚引用管理堆外内存。
 *
 * @author liuyuancheng
 */
@Slf4j
public class PhantomRefDemo {

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<Student> referenceQueue = new ReferenceQueue<>();
        final Thread thread = new Thread(() -> {
            try {
                log.info("daemon started.");
                int cnt = 0;
                PhantomReference<Student> k;
                while((k = (PhantomReference) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        PhantomReference<Student> stu = new PhantomReference<Student>(new Student("xiaosan", 21), referenceQueue);
        log.info("虚引用总是返回 {}",stu.get());
        System.gc();
        thread.join(100);
    }

}

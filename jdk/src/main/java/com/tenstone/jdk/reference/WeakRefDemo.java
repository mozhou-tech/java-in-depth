package com.tenstone.jdk.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class WeakRefDemo {

    /**
     * Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
     * 在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<Student> referenceQueue = new ReferenceQueue<>();
        final Thread thread = new Thread(() -> {
            try {
                log.info("daemon started.");
                int cnt = 0;
                WeakReference<Student> k;
                while((k = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        WeakReference<Student> stu = new WeakReference<Student>(new Student("xiaosan", 21), referenceQueue);
        System.gc();
        if (Objects.isNull(stu.get())) {
            log.info("stu 已被gc回收");
        }
        thread.join(100);
    }

}

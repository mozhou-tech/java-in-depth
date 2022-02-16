package com.tenstone.jdk.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class ReferenceQueueDemo {

    private static ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();
    private static int _1M = 1024 * 1024;

    /**
     * vm options -XX:+PrintGCDetails -Xmx256m
     */
    public static void main(String[] args) {
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>(12);
        // 后台线程，监听
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while ((k = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch (InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[_1M];
            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, referenceQueue);
            map.put(weakReference, value);
            System.out.println("free mem: "+Runtime.getRuntime().freeMemory());
        }
        System.out.println("map.size->" + map.size());
    }
}

package com.tenstone.jdk.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class SoftRefDemo {

    // VM options -Xmx256m -Xms128m
    public static void main(String[] args) {
        SoftReference<Student> softReference = new SoftReference<Student>(new Student("xiaosan", 4));
        log.info("启动时正常读取 {}", softReference.get());
        Map<Integer, byte[]> mem = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            mem.put(i, new byte[1024 * 1024]);
            log.info("剩余堆空间 {}", Runtime.getRuntime().freeMemory() / (1024 * 1024));
            System.gc();
            if (Objects.isNull(softReference.get())) {
                log.info("堆内存不足，softReference 被gc");
            }
        }
    }

}

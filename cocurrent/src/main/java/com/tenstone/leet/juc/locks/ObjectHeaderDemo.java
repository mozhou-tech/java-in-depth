package com.tenstone.leet.juc.locks;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 */
@Slf4j
public class ObjectHeaderDemo {

    /**
     * 对象头
     * 1. mark word (8 bytes) hashCode,锁标志位，gc年龄
     * 2. klass pointer (开启指针压缩 4 bytes，不开启指针压缩 8bytes -XX:-UseCompressedOops +UseCompressedClassPoints)
     * 3. object data
     * 4. object alignment gap （Java 对象的大小必须是8 bytes的倍数，不够则填充）
     * @param args
     */
    public static void main(String[] args) {
        log.debug("\n=========================================VM.current.details()====================================");
        log.debug("{}", VM.current().details());
        log.debug("\n=========================================String.class============================================");
        log.debug("{}", ClassLayout.parseClass(String.class).toPrintable());
        log.debug("\n=========================================new Object()============================================");
        log.debug("{}", ClassLayout.parseInstance(new Object()).toPrintable());
        log.debug("\n=========================================hello String============================================");
        String hello = "hello".intern();
        log.debug("{}", ClassLayout.parseInstance(hello).toPrintable());
        log.debug("\n=========================================empty String============================================");
        log.debug("{}", ClassLayout.parseInstance("").toPrintable());
    }
}

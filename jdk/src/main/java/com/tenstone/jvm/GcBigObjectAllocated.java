package com.tenstone.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class GcBigObjectAllocated {

    /**
     * 需要配置VM arguments参数（-verbose:gc -XX:+PrintGCDetails）默认是G1
     * -XX:+UseSerialGC
     *
     * @param args
     */
    public static void main(String[] args) {
        // 新生代，新生代
        byte[] b1 = new byte[4 * 1024 * 1024];
        // 大对象直接被分配到老年代
        byte[] b2 = new byte[400 * 1024 * 1024];
    }

}

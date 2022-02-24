package com.tenstone.jdk.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by liuyuancheng on 2022/2/23  <br/>
 * 打印当前使用的垃圾回收器信息
 * young/old 代默认所使用的 collector
 *
 * @author liuyuancheng
 */
public class GCDemo1 {

    public static void main(String[] args) {
        try {
            List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
            for (GarbageCollectorMXBean gcMxBean : gcMxBeans) {
                System.out.println(gcMxBean.getName());
            }
        } catch (Exception exp) {
            System.err.println(exp);
        }
    }

}

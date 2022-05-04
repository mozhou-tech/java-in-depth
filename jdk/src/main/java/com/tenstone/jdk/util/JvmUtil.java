package com.tenstone.jdk.util;

import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;


public class JvmUtil {

    public static final int getProcessID() {
        //  ManagementFactory是一个在运行时管理和监控Java VM的工厂类
        //  它能提供很多管理VM的静态接口的运行时实例，比如RuntimeMXBean
        //  RuntimeMXBean是Java虚拟机的运行时管理接口.
        //  取得VM运行管理实例，到管理接口句柄
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        //  取得VM运行管理实例的名称，也是JVM运行实例的名称
        String jvmInstanceName = runtimeMXBean.getName();
        return Integer.valueOf(jvmInstanceName.split("@")[0]).intValue();
    }

    /**
     * 取得当前线程名称
     *
     * @return
     */
    public static String curThreadName() {
        return Thread.currentThread().getName();
    }

    public static String getAddresses(Object... objects) {
        StringBuffer sb = new StringBuffer();
        sb.append("0x");
        // sun.arch.data.model=32 // 32 bit JVM
        // sun.arch.data.model=64 // 64 bit JVM
        boolean is64bit = Integer.parseInt(System.getProperty("sun.arch.data.model")) == 32 ? false : true;
        Unsafe unsafe = getUnsafe();
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                // 输出指针地址
                sb.append(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        sb.append(", +" + Long.toHexString(i2 - last));
                    else
                        sb.append(", -" + Long.toHexString(last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        return sb.toString();
    }

    public static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }


    public static void main(String... args) {
        Double[] ascending = new Double[16];
        for (int i = 0; i < ascending.length; i++)
            ascending[i] = (double) i;

        Double[] descending = new Double[16];
        for (int i = descending.length - 1; i >= 0; i--)
            descending[i] = (double) i;

        Double[] shuffled = new Double[16];
        for (int i = 0; i < shuffled.length; i++)
            shuffled[i] = (double) i;
        Collections.shuffle(Arrays.asList(shuffled));

        com.crazymakercircle.util.Print.tcfo("Before GC");
        com.crazymakercircle.util.Print.tcfo("ascending：" + getAddresses(ascending));
        com.crazymakercircle.util.Print.tcfo("descending：" + getAddresses(descending));
        com.crazymakercircle.util.Print.tcfo("shuffled：" + getAddresses(shuffled));

        System.gc();
        com.crazymakercircle.util.Print.tcfo("\nAfter GC");
        com.crazymakercircle.util.Print.tcfo("ascending：" + getAddresses(ascending));
        com.crazymakercircle.util.Print.tcfo("descending：" + getAddresses(descending));
        com.crazymakercircle.util.Print.tcfo("shuffled：" + getAddresses(shuffled));

        System.gc();
        com.crazymakercircle.util.Print.tcfo("\nAfter GC 2");
        com.crazymakercircle.util.Print.tcfo("ascending：" + getAddresses(ascending));
        com.crazymakercircle.util.Print.tcfo("descending：" + getAddresses(descending));
        com.crazymakercircle.util.Print.tcfo("shuffled：" + getAddresses(shuffled));

        Object o = new Object();
        com.crazymakercircle.util.Print.tcfo(getAddresses(o));
    }


}

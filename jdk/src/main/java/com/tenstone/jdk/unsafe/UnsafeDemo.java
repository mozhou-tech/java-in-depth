package com.tenstone.jdk.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by liuyuancheng on 2022/2/27  <br/>
 * Java使用Unsafe接口操作数组Demo
 *
 * @author liuyuancheng
 */
public class UnsafeDemo {

    private static final sun.misc.Unsafe UNSAFE;

    private static final long TBASE;

    private static final int TSHIFT;

    static {
        int ts;
        try {
            UNSAFE = getUnsafe();
            TBASE = UNSAFE.arrayBaseOffset(String[].class);
            ts = UNSAFE.arrayIndexScale(String[].class);
        } catch (Exception e) {
            throw new Error(e);
        }
        TSHIFT = 31 - Integer.numberOfLeadingZeros(ts);
    }

    static Unsafe getUnsafe() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        // 对于反射操作静态字段，f.get(null) 传入任何参数即刻（静态属性属于Class，而不是对象）
        return (Unsafe) f.get(null);
    }

    @SuppressWarnings("unchecked")
    static String entryAt(String[] tab, int i) {
        // 从对象的指定偏移量处获取变量的引用，使用volatile的加载语义
        return (String) UNSAFE.getObjectVolatile(tab, ((long) i << TSHIFT) + TBASE);
    }

    public static void main(String[] args) {
        int nLen = 37;
        String[] table = new String[nLen];
        // 创建 0-36的数组
        for (int i = 0; i < nLen; i++) {
            table[i] = "数值为:  " + (i + 26);
        }
        String str = entryAt(table, 23);
        System.out.println(TBASE);
        System.out.println(str);
    }
}

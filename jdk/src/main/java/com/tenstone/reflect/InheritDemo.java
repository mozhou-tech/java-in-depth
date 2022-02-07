package com.tenstone.reflect;

import java.util.Arrays;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class InheritDemo {

    public static void main(String[] args) {
        Class<?> cls = Student.class;
        final Class<?> superclass = cls.getSuperclass();
        System.out.println(superclass.getSimpleName());
        final Class<?> superclass1 = superclass.getSuperclass();
        // 打印父类
        System.out.println(superclass1);
        // 打印接口
        System.out.println(Arrays.toString(superclass.getInterfaces()));
        final Class<?> superclass2 = superclass1.getSuperclass();
        // Object的父类为null
        System.out.println(superclass2);
    }

}

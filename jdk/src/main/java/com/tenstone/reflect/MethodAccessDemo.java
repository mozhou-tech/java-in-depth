package com.tenstone.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class MethodAccessDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> cls = AbstractPerson.class;
        for (Method method : cls.getDeclaredMethods()) {
            method.setAccessible(true);
            Method method1 = cls.getDeclaredMethod(method.getName());
        }
    }

}

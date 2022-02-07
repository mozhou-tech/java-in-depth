package com.tenstone.reflect;

import java.lang.reflect.Constructor;
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
            // 获取方法列表
            Method method1 = cls.getDeclaredMethod(method.getName());
            System.out.println(method1.getName());
        }
        for (Constructor<?> constructor : cls.getConstructors()) {
            // 获取构造参数
            final Class<?>[] parameterTypes = constructor.getParameterTypes();
        }
    }

}

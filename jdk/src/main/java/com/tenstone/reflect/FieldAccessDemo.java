package com.tenstone.reflect;

import java.lang.reflect.Field;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class FieldAccessDemo {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> cls = Student.class;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            final Field field1 = cls.getDeclaredField(field.getName());
            System.out.println(field1.getName());
        }
    }

}

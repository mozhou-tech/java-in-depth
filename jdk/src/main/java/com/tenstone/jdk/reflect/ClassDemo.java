package com.tenstone.jdk.reflect;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.util.Assert;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 * 通过Class实例获取class信息的方法称为反射（Reflection）。
 *
 * @author liuyuancheng
 */


public class ClassDemo {

    static class InnerClass {

    }

    public static void main(String[] args) throws Exception {

        class MemberClass {

        }

        Assert.isTrue(method1() == String.class);
        Assert.isTrue(method2() == String.class);
        Assert.isTrue(method3() == String.class);
        Assert.isTrue(InnerClass.class.isMemberClass(), "内部类");
        Assert.isTrue(MemberClass.class.isLocalClass(),"Local Class局部类");
        Assert.isTrue(PerformanceSensitive.class.isAnnotation(), "注解");
        Assert.isTrue(Runnable.class.isInterface(),"接口");
        Assert.isTrue(String.class.isInstance("s"),"xx是class的实例");
        final String s = String.class.getConstructor(String.class).newInstance("hello world!");
        Assert.isTrue(s.contains("hello world"),"通过反射创建实例");
    }

    public static Class method1() {
        return String.class;
    }

    public static Class method2() {
        final String s = "";
        return s.getClass();
    }

    public static Class method3() throws ClassNotFoundException {
        return Class.forName("java.lang.String");
    }

}

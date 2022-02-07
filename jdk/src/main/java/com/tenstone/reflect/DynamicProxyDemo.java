package com.tenstone.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class DynamicProxyDemo implements IDynamicProxyDemo {

    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)  {
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        // Java标准库提供了一种动态代理（Dynamic Proxy）的机制：可以在运行期动态创建某个interface的实例。
        // 我们并不去编写实现类，而是直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个Hello接口对象。
        // 这种没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。JDK提供的动态创建接口对象的方式，就叫动态代理。
        IDynamicProxyDemo hello = (IDynamicProxyDemo) Proxy.newProxyInstance(
                // 传入ClassLoader
                IDynamicProxyDemo.class.getClassLoader(),
                // 传入要实现的接口
                new Class[] { IDynamicProxyDemo.class },
                // 传入处理调用方法的InvocationHandler
                handler);
        hello.morning("Bob");
    }
}

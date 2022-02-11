package com.tenstone.annotations.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class DynamicProxyDemo implements IDynamicProxy {

    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }


    /**
     * JDK动态代理必须要有接口
     *
     * @param args
     */
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
        // 反射机制生成一个代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理
        IDynamicProxy hello = (IDynamicProxy) Proxy.newProxyInstance(
                // 传入ClassLoader
                IDynamicProxy.class.getClassLoader(),
                // 传入要实现的接口
                new Class[] { IDynamicProxy.class },
                // 传入处理调用方法的InvocationHandler
                handler);
        hello.morning("Bob");
    }
}

package com.tenstone.annotations.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class CglibDemo {

    public static void main(String[] args) {
        // Enhancer类是CGLib中的一个字节码增强器
        Enhancer enhancer = new Enhancer();
        // 首先将被代理类TargetObject设置成父类，然后设置拦截器TargetInterceptor，
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        // 最后执行enhancer.create()动态生成一个代理类，
        // 并从Object强制转型成父类型TargetObject。
        TargetObject targetObject2 = (TargetObject) enhancer.create();
        System.out.println("main:" + TargetObject.class.getName());
        System.out.println("main:" + targetObject2.getClass().getName());
        System.out.println("main:" + targetObject2.method1("mmm1"));
        System.out.println("main:" + targetObject2.method2(100));
        System.out.println("main:" + targetObject2.method3(200));
    }

}

package com.tenstone.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2 = (TargetObject) enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }
}

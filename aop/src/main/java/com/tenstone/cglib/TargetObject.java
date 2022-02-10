package com.tenstone.cglib;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 * 没有实现接口，需要CGlib动态代理的目标类
 *
 * 被代理的类
 *
 * @author liuyuancheng
 */
public class TargetObject {
    public String method1(String paramName) {
        return paramName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}

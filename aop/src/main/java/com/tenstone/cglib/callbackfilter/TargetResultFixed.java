package com.tenstone.cglib.callbackfilter;

import net.sf.cglib.proxy.FixedValue;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 * 表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
 *
 * @author liuyuancheng
 */
public class TargetResultFixed implements FixedValue {

    /**
     * 该类实现FixedValue接口，同时锁定回调值为999
     * (整型，CallbackFilter中定义的使用FixedValue型回调的方法为getConcreteMethodFixedValue，该方法返回值为整型)。
     */
    @Override
    public Object loadObject() {
        System.out.println("fixedValue:锁定结果");
        Object obj = 999;
        return obj;
    }
}

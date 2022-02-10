package com.tenstone.cglib.lazy;

import com.tenstone.cglib.TargetObject;
import net.sf.cglib.proxy.Dispatcher;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 * Dispatcher接口同样继承于Callback，也是一种回调类型。
 *
 * 但是Dispatcher和LazyLoader的区别在于：LazyLoader只在第一次访问延迟加载属性时触发代理类回调方法，
 * 而Dispatcher在每次访问延迟加载属性时都会触发代理类回调方法。
 *
 * @author liuyuancheng
 */
public class ConcreteClassDispatcher implements Dispatcher {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("before Dispatcher...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("xxx");
        propertyBean.setValue(new TargetObject());
        System.out.println("after Dispatcher...");
        return propertyBean;
    }
}

package com.tenstone.annotations.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class TargetInterceptor implements MethodInterceptor {
    /**
     * 重写方法拦截在方法前和方法后加入业务
     * Object obj为目标对象
     * Method method为目标方法
     * Object[] params 为参数
     * MethodProxy proxy CGlib方法代理对象
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params,
                            MethodProxy proxy) throws Throwable {

        System.out.println("intercept:调用前 目标对象：" + obj.getClass().getSimpleName());
        // 传入目标对象和参数
        Object result = proxy.invokeSuper(obj, params);
        System.out.println("intercept:" + result);
        System.out.println("intercept:调用后");

        return result;
    }

}

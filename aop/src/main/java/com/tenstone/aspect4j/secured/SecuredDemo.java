package com.tenstone.aspect4j.secured;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
public class SecuredDemo {

    /**
     * @EnableAspectJAutoProxy 在Spring中开启AspectJ支持
     *
     * @param args
     */
    public static void main(String[] args) {

        SecuredMethod service = new SecuredMethod();

        // 访问未被锁的方法
        service.unlockedMethod();

        // 访问被锁的方法
        service.lockedMethod();

        service.afterMethod();
        service.beforeMethod();
        service.returningMethod("world");
        service.throwMethod();
    }

}

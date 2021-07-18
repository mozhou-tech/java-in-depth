package com.tenstone.leet.patterns.creation.singleton.static_inner_class;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class Singleton {

    private Singleton() {

    }

    /**
     * 静态内部类单例模式也称单例持有者模式，实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的,
     * 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。
     */
    private static class InstanceHolder {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getSingleton() {
        return InstanceHolder.instance;
    }
}

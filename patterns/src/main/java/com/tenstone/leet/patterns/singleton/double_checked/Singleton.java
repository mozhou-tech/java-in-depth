package com.tenstone.leet.patterns.singleton.double_checked;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class Singleton {

    private volatile static Singleton singleton = null;

    private Singleton() {
        System.out.println("双检锁初始化");
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

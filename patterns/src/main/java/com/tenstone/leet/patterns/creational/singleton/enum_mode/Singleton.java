package com.tenstone.leet.patterns.creational.singleton.enum_mode;

/**
 * 这种方式是Effective Java作者Josh Bloch提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 *
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public enum Singleton {

    INSTANCE;

    public static Singleton getSingleton() {
        return INSTANCE;
    }

    public void sayHello(){
        System.out.println("hello");
    }
}

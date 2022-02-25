package com.tenstone.leet.patterns.base_creational.singleton.lazy_mode;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    /**
     * 使用private 禁止从构造函数创建实例（确保单例）
     */
    private Singleton(){
        System.out.println("生成一个实例");
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

package com.tenstone.leet.patterns.creational.singleton.lazy_mode;


/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getSingleton();
        Singleton obj2 = Singleton.getSingleton();
        // 打印hashCode (可能是内存地址，但是会被Overwrite)
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        // 打印内存地址
        System.out.println(System.identityHashCode(obj1));
        System.out.println(System.identityHashCode(obj2));
        if (obj1.equals(obj2)) {
            System.out.println("obj1和obj2是相同实例");
        } else {
            System.out.println("obj1和obj2是不同实例");
        }
    }

}

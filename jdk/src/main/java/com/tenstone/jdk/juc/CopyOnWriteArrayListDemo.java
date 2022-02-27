package com.tenstone.jdk.juc;

/**
 * Created by liuyuancheng on 2022/2/27  <br/>
 * ArrayList的线程安全版本
 *
 * @author liuyuancheng
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        a = b;
        System.out.println(a);
    }
}

package com.tenstone.jdk.basic;

/**
 * Created by liuyuancheng on 2022/5/2  <br/>
 *
 * @author liuyuancheng
 */
public class WhileFor {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        for (;;){
            System.out.println("hello");
        }
    }
    public static void test2(){
        while (true){
            System.out.println("world");
        }
    }
}

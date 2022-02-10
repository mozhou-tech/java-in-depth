package com.tenstone.error;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class ThrowableDemo {

    /**
     * throwable 有两个子类：Error和Exception
     * RuntimeException是Exception的子类
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        throw new Throwable("hello");
    }
}

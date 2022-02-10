package com.tenstone.error.types;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class ApplicationExceptionDemo {

    /**
     * 由程序或者API程序抛出的异常。例如 IllegalArgumentException 类，IllegalStateException 类。
     * @param args
     */
    public static void main(String[] args) {
        throw new IllegalStateException();
    }

}

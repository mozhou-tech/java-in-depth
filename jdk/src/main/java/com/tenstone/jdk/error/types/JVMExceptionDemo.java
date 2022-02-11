package com.tenstone.jdk.error.types;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class JVMExceptionDemo {

    /**
     * JVM(Java虚拟机) 异常：由 JVM 抛出的异常或错误。
     * NullPointerException 类，ArrayIndexOutOfBoundsException 类，ClassCastException 类。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[1];
        System.out.println(arr[11]);
    }
}

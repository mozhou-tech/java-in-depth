package com.tenstone.jdk.error;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class UncheckedExceptionDemo2 {

    /**
     * These are the exceptions that are not checked at compile time.
     * In C++, all exceptions are unchecked,
     * so it is not forced by the compiler to either handle or specify the exception.
     * It is up to the programmers to be civilized, and specify or catch the exceptions.
     * In Java exceptions under {Error and RuntimeException} classes are unchecked exceptions,
     * everything else under throwable is checked.
     * Checked和Unchecked区别在于，是否在编译时被发现
     * @param args
     */
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());
    }
}

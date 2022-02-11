package com.tenstone.jdk.error;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class UncheckedExceptionDemo {

    /**
     * These are the exceptions that are not checked at compile time.
     * In C++, all exceptions are unchecked,
     * so it is not forced by the compiler to either handle or specify the exception.
     * It is up to the programmers to be civilized, and specify or catch the exceptions.
     * In Java exceptions under {Error and RuntimeException} classes are unchecked exceptions,
     * everything else under throwable is checked.
     * @param args
     */
    public static void main(String[] args) {
        // Here we are dividing by 0
        // which will not be caught at compile time
        // as there is no mistake but caught at runtime
        // because it is mathematically incorrect
        int x = 0;
        int y = 10;
        int z = y / x;
    }
}

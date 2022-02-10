package com.tenstone.aspect4j.secured;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
public class SecuredMethod {

    @Secured(isLocked = true)
    public void lockedMethod() {
        System.out.println("lockedMethod called.");
    }

    @Secured(isLocked = false)
    public void unlockedMethod() {
        System.out.print("unlockedMethod called.");
    }

    public void afterMethod() {

    }

    public void beforeMethod() {

    }

    public String returningMethod(String name) {
        return "hello " + name + "!";
    }

    public void throwMethod() {
        throw new RuntimeException("error");
    }
}

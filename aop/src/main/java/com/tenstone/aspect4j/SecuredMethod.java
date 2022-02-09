package com.tenstone.aspect4j;

import lombok.extern.slf4j.Slf4j;

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
        System.out.println("unlockedMethod called.");
    }
}

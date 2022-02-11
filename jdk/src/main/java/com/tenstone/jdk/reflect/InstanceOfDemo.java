package com.tenstone.jdk.reflect;

import org.springframework.util.Assert;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class InstanceOfDemo {

    public static void main(String[] args) {
        Double doubleV = 1.1D;
        // Double 继承自Number，Number实现了Comparable接口
        Assert.isTrue(doubleV instanceof Comparable,"是Comparable");
        Assert.isTrue(doubleV instanceof Number,"是Number");
        Assert.isTrue(doubleV instanceof Double, "是Double");
    }

}

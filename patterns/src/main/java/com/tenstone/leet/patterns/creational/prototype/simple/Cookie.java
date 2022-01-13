package com.tenstone.leet.patterns.creational.prototype.simple;

/**
 * Created by liuyuancheng on 2021/7/13  <br/>
 */
public class Cookie implements Cloneable {

    public Object clone() throws CloneNotSupportedException
    {
        //In an actual implementation of this pattern you would now attach references to
        //the expensive to produce parts from the copies that are held inside the prototype.
        return (Cookie) super.clone();
    }
}

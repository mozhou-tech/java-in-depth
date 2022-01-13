package com.tenstone.leet.patterns.creational.builder.director;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public abstract class Builder {

    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();

}

package com.tenstone.leet.patterns.abstract_factory.factory;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public abstract class Item {
    protected String caption;
    public Item(String caption){
        this.caption = caption;
    }
    public abstract String makeHTML();
}

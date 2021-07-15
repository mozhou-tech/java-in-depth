package com.tenstone.leet.patterns.abstract_factory.factory;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public abstract class Link extends Item{

    protected String url;

    public Link(String caption,String url) {
        super(caption);
        this.url = url;
    }
}

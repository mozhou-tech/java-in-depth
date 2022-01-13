package com.tenstone.leet.patterns.creational.abstract_factory.listfactory;

import com.tenstone.leet.patterns.creational.abstract_factory.factory.Factory;
import com.tenstone.leet.patterns.creational.abstract_factory.factory.Link;
import com.tenstone.leet.patterns.creational.abstract_factory.factory.Page;
import com.tenstone.leet.patterns.creational.abstract_factory.factory.Tray;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}

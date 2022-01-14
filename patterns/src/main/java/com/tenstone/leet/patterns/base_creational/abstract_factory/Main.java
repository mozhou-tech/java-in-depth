package com.tenstone.leet.patterns.base_creational.abstract_factory;

import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Factory;
import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Link;
import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Page;
import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Tray;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = Factory.getFactory("com.tenstone.leet.patterns.creation.abstract_factory.listfactory.ListFactory");
        Link baidu = factory.createLink("Baidu","https://www.baidu.com");
        Link google = factory.createLink("Google","https://www.google.com");
        Tray tray = factory.createTray("Search Engine");
        tray.add(baidu);
        tray.add(google);
        Page page = factory.createPage("Search Engine Page","yates");
        page.add(baidu);
        page.add(google);
        System.out.println(page.makeHTML());
    }

}

package com.tenstone.leet.patterns.abstract_factory;

import com.tenstone.leet.patterns.abstract_factory.factory.Factory;
import com.tenstone.leet.patterns.abstract_factory.factory.Link;
import com.tenstone.leet.patterns.abstract_factory.factory.Tray;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = Factory.getFactory("com.tenstone.leet.patterns.abstract_factory.listfactory.TableFactory");
        Link baidu = factory.createLink("Baidu","https://www.baidu.com");
        Link google = factory.createLink("Google","https://www.google.com");
        Tray tray = factory.createTray("Search Engine");
        tray.add(baidu);
        tray.add(google);
        System.out.println(tray.makeHTML());
    }

}

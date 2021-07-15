package com.tenstone.leet.patterns.abstract_factory;

import com.tenstone.leet.patterns.abstract_factory.factory.Factory;
import com.tenstone.leet.patterns.abstract_factory.factory.Link;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = Factory.getFactory("com.tenstone.leet.patterns.abstract_factory.listfactory.ListFactory");
        Link baidu = factory.createLink("Baidu","https://www.baidu.com");
        System.out.println(baidu.makeHTML());
    }

}

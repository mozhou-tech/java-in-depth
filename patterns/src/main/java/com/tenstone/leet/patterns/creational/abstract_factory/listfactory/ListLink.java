package com.tenstone.leet.patterns.creational.abstract_factory.listfactory;

import com.tenstone.leet.patterns.creational.abstract_factory.factory.Link;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}

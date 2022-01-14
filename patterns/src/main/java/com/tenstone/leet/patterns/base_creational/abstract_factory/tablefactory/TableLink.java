package com.tenstone.leet.patterns.base_creational.abstract_factory.tablefactory;

import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Link;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public class TableLink extends Link {

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}

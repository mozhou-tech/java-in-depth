package com.tenstone.leet.patterns.creational.abstract_factory.listfactory;

import com.tenstone.leet.patterns.creational.abstract_factory.factory.Item;
import com.tenstone.leet.patterns.creational.abstract_factory.factory.Tray;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption);
        buffer.append("\n");
        buffer.append("<ul>\n");
        for (Item item : tray) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}

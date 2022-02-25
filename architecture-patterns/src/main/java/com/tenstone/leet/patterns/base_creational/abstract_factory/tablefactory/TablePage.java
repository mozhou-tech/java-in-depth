package com.tenstone.leet.patterns.base_creational.abstract_factory.tablefactory;

import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Item;
import com.tenstone.leet.patterns.base_creational.abstract_factory.factory.Page;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public class TablePage extends Page{

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("<html><head><title>");
        buffer.append(title);
        buffer.append("</title></head>");
        buffer.append("<body>\n");
        buffer.append("<h1>").append(title).append("</h1>\n");
        buffer.append("<ul>\n");
        for (Item item : content) {
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>").append(author).append("</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}

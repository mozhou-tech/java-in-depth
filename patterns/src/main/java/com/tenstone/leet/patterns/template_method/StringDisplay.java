package com.tenstone.leet.patterns.template_method;

import java.nio.charset.StandardCharsets;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class StringDisplay extends AbstractDisplay {

    private final String string;

    private final int width;

    public StringDisplay(String s) {
        this.string = s;
        this.width = s.getBytes(StandardCharsets.UTF_8).length;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    /**
     * 模板方法
     */
    public void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}

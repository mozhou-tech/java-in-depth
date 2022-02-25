package com.tenstone.leet.patterns.base_behavioral.template_method;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class CharDisplay extends AbstractDisplay{

    private final char ch;

    public CharDisplay(char h) {
        this.ch = h;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }

}

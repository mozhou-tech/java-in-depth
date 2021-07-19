package com.tenstone.leet.patterns.decorator;

/**
 * Created by liuyuancheng on 2021/7/19  <br/>
 */
public class Border extends Display {
    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }

    @Override
    public int getColumns() {
        return 0;
    }

    @Override
    public int getRows() {
        return 0;
    }

    @Override
    public String getRowText(int row) {
        return null;
    }
}

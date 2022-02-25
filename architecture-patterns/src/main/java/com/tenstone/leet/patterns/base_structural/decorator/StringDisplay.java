package com.tenstone.leet.patterns.base_structural.decorator;

/**
 * Created by liuyuancheng on 2021/7/19  <br/>
 */
public class StringDisplay extends Display {

    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }


    @Override
    public int getColumns() {
        return string.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}

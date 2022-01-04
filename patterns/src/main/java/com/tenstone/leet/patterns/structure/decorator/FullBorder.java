package com.tenstone.leet.patterns.structure.decorator;

/**
 * Created by liuyuancheng on 2021/7/19  <br/>
 */
public class FullBorder extends Border {

    /**
     * 委托，推原功能进行一顿扩展
     *
     * @param display
     */
    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == display.getRows() + 1) { // 上边框和下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    private String makeLine(char c, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(c);
        }
        return buf.toString();
    }
}

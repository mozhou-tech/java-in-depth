package com.tenstone.leet.patterns.structural.decorator;

/**
 * Created by liuyuancheng on 2021/7/19  <br/>
 */
public abstract class Display {

    /**
     * 获取横向字符数
     * @return
     */
    public abstract int getColumns();

    /**
     * 获取纵向字符数
     * @return
     */
    public abstract int getRows();

    /**
     * 获取第row行字符串
     *
     * @param row
     * @return
     */
    public abstract String getRowText(int row);

    public final void show(){
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}

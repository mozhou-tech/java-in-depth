package com.tenstone.leet.patterns.action.chan_of_responsibility;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
public class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}

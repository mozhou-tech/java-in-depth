package com.tenstone.leet.patterns.structural.bridge;

/**
 * Created by liuyuancheng on 2021/7/16  <br/>
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}

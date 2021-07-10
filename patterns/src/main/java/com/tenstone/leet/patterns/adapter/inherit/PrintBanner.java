package com.tenstone.leet.patterns.adapter.inherit;

import com.tenstone.leet.patterns.adapter.Print;

/**
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String value) {
        super(value);
    }

    @Override
    public void printWeak() {
        this.showWithParen();
    }

    @Override
    public void printStrong() {
        this.showWithAster();
    }
}

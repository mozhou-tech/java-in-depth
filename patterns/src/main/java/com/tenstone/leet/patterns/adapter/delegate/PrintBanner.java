package com.tenstone.leet.patterns.adapter.delegate;

import com.tenstone.leet.patterns.adapter.Print;

/**
 * 打印Banner
 *
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class PrintBanner implements Print {

    private final Banner banner;

    public PrintBanner(String value) {
        banner = new Banner(value);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}

package com.tenstone.leet.patterns.structural.adapter.delegate;


/**
 * 打印Banner
 *
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class PrintBanner extends Print {

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

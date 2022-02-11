package com.tenstone.leet.patterns.base_structural.adapter.delegate;

/**
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class Banner {

    private final String value;

    public Banner(String value) {
        this.value = value;
    }

    public void showWithParen() {
        System.out.println("(" + value + ")");
    }

    public void showWithAster() {
        System.out.println("*" + value + "*");
    }

}

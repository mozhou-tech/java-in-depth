package com.tenstone.leet.patterns.base_structural.adapter;

import com.tenstone.leet.patterns.base_structural.adapter.inherit.Print;
import com.tenstone.leet.patterns.base_structural.adapter.inherit.PrintBanner;

/**
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class InheritMain {

    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printStrong();
        print.printWeak();
    }

}

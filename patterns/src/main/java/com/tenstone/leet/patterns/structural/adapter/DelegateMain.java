package com.tenstone.leet.patterns.structural.adapter;

import com.tenstone.leet.patterns.structural.adapter.delegate.Print;
import com.tenstone.leet.patterns.structural.adapter.delegate.PrintBanner;

/**
 * 基于委托实现的Adapter （Wrapper）
 *
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class DelegateMain {

    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printStrong();
        print.printWeak();
    }

}

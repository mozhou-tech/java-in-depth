package com.tenstone.leet.patterns.structure.bridge;

/**
 * Created by liuyuancheng on 2021/7/16  <br/>
 */
public class Display {

    private final DisplayImpl impl;

    public Display(DisplayImpl impl){
        this.impl = impl;
    }

    public void open(){
        impl.rawOpen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }
}

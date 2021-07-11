package com.tenstone.leet.patterns.template_method;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public abstract class AbstractDisplay {

    public abstract void open();
    public abstract void print();
    public abstract void close();

    /**
     * 调用子类中的方法实现
     */
    public final void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }

}

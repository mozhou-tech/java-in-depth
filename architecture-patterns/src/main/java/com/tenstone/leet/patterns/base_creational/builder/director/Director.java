package com.tenstone.leet.patterns.base_creational.builder.director;

/**
 * 监工
 *
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class Director {

    private final Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上至下午");
        builder.makeItems(new String[]{
                "早上好。",
                "下午好"
        });
        builder.makeString("晚上");
        builder.makeItems(new String[]{
                "晚上好。",
                "晚安。",
                "再见。"
        });
        builder.close();
    }
}

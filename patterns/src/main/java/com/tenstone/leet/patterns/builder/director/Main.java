package com.tenstone.leet.patterns.builder.director;


import org.junit.jupiter.api.Test;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class Main {

    @Test
    void plain(){
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);
    }

    @Test
    void html(){
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Director director = new Director(htmlBuilder);
        director.construct();
        String filename = htmlBuilder.getResult();
        System.out.println(filename + "文件编写完成");
    }
}

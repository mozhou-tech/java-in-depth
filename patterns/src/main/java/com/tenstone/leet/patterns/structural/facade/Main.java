package com.tenstone.leet.patterns.structural.facade;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 *
 * @author liuyuancheng
 */
public class Main {

    public static void main(String[] args) {
        String filename = Constants.rootDir + "/welcome.html";
        PageMakerFacade.makeWelcomePage("hyuki@hyuki.com",filename);
    }
}

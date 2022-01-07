package com.tenstone.leet.patterns.structure.facade;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 *
 * @author liuyuancheng
 */
public class Main {

    public static void main(String[] args) {
        String filename = System.getProperty("user.dir") + "/patterns/src/main/java/com/tenstone/leet/patterns/structure/facade/welcome.html";
        PageMakerFacade.makeWelcomePage("hyuki@hyuki.com",filename);
    }
}

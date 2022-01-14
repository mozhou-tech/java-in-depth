package com.tenstone.leet.patterns.base_structural.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 * Facade 调用其它类完成工作
 *
 * @author liuyuancheng
 */
public class PageMakerFacade {

    private PageMakerFacade() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph(username + "欢迎来到" + username + "的主页");
            writer.paragraph("等着你的邮件哦");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ") ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

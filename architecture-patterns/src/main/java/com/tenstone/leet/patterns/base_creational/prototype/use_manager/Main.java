package com.tenstone.leet.patterns.base_creational.prototype.use_manager;

/**
 * Created by liuyuancheng on 2021/7/12  <br/>
 */
public class Main {

    public static void main(String[] args) {
        // 准备
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        // 注册原型
        manager.register("strong message", upen);
        manager.register("warning message", mbox);
        manager.register("slash message", sbox);

        // 生成
        ProductPrototype p1 = manager.create("strong message");
        p1.use("Hello,world.");
        ProductPrototype p2 = manager.create("warning message");
        p2.use("Hello,world.");
        ProductPrototype p3 = manager.create("slash message");
        p3.use("Hello,world.");
    }
}

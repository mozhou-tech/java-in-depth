package com.tenstone.leet.patterns.creation.factory_method;

import com.tenstone.leet.patterns.creation.factory_method.framework.Factory;
import com.tenstone.leet.patterns.creation.factory_method.framework.Product;
import com.tenstone.leet.patterns.creation.factory_method.idcard.IDCardFactory;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class Main {

    public static void main(String[] args) {

        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小黄");
        Product card2 = factory.create("大绿");
        Product card3 = factory.create("小黑");
        card1.use();
        card2.use();
        card3.use();
        System.out.println("拥有卡片的人：" + factory.readRegisterBook());

    }

}

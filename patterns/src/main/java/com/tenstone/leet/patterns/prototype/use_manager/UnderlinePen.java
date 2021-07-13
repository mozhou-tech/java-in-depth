package com.tenstone.leet.patterns.prototype.use_manager;

/**
 * 原型实现
 *
 * Created by liuyuancheng on 2021/7/12  <br/>
 */
public class UnderlinePen implements ProductPrototype {

    private final char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    /**
     * 创建克隆
     * @return
     */
    @Override
    public ProductPrototype createClone() {
        ProductPrototype p = null;
        try {
            p = (ProductPrototype) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}

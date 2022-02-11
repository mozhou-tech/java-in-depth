package com.tenstone.leet.patterns.base_creational.prototype.use_manager;

/**
 * Created by liuyuancheng on 2021/7/12  <br/>
 */
public class MessageBox implements ProductPrototype {

    private final char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

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

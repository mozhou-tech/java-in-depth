package com.tenstone.leet.patterns.creation.factory_method.idcard;

import com.tenstone.leet.patterns.creation.factory_method.framework.Product;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class IDCard extends Product {

    private final String owner;

    public IDCard(String owner) {
        System.out.println("制作"+owner+"的ID卡片");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡片");
    }

    public String getOwner() {
        return owner;
    }
}

package com.tenstone.leet.patterns.factory_method;

import java.util.ArrayList;
import java.util.List;

/**
 * ID卡工厂
 *
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public class IDCardFactory extends Factory {

    private final List<String> owners = new ArrayList<>();

    @Override
    protected void registerProduct(Product p) {
        owners.add(((IDCard) p).getOwner());
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    public String printRegisterBook() {
        return owners.toString();
    }
}

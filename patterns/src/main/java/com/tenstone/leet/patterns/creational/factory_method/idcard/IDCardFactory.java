package com.tenstone.leet.patterns.creational.factory_method.idcard;

import com.tenstone.leet.patterns.creational.factory_method.framework.Product;
import com.tenstone.leet.patterns.creational.factory_method.framework.Factory;

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

    @Override
    public String readRegisterBook() {
        return owners.toString();
    }
}

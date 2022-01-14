package com.tenstone.leet.patterns.base_creational.abstract_factory.factory;

import java.util.ArrayList;

/**
 * Created by liuyuancheng on 2021/7/15  <br/>
 */
public abstract class Tray extends Item{
    protected ArrayList<Item> tray = new ArrayList();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item){
        tray.add(item);
    }
}

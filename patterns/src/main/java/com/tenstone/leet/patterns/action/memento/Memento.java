package com.tenstone.leet.patterns.action.memento;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
public class Memento {

    private int money;

    private List<String> fruits = Lists.newArrayList();

    public int getMoney() {
        return money;
    }

    public Memento(int money) {
        this.money = money;
    }

    public void addFruit(String fruit) {
        fruits.add(fruit);
    }

    public List<String> getFruits() {
        return fruits;
    }
}

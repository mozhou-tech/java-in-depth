package com.tenstone.leet.patterns.structural.flyweight;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * Alchemist's shop has shelves full of magic potions. Many of the potions are the same so there is no need to create
 * a new object for each of them.
 * Instead, one object instance can represent multiple shelf items so the memory footprint remains small.
 *
 * In Short: It is used to minimize memory usage or computational expenses by sharing as much as possible with similar objects.
 *
 * @author liuyuancheng
 */
public class Main {

    public static void main(String[] args) {
        AlchemistShop alchemistShop = new AlchemistShop();

        // 同一种Potion，内存地址是一样的，意味着HashCode一致
        alchemistShop.drinkPotions();
    }

}

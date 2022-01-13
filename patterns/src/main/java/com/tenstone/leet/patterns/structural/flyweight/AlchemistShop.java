package com.tenstone.leet.patterns.structural.flyweight;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * AlchemistShop contains two shelves of magic potions. The potions are created using the aforementioned PotionFactory
 *
 * @author liuyuancheng
 */
@Slf4j
public class AlchemistShop {

    private List<Potion> topShelf;

    private List<Potion> bottomShelf;

    public AlchemistShop() {
        var factory = new PotionFactory();
        topShelf = Lists.newArrayList(
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.STRENGTH),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.STRENGTH),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.HEALING)
        );
        bottomShelf = Lists.newArrayList(
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.HOLY_WATER),
                factory.createPotion(PotionType.HOLY_WATER)
        );
    }


    public List<Potion> getTopShelf() {
        return topShelf;
    }

    public List<Potion> getBottomShelf() {
        return bottomShelf;
    }

    public void drinkPotions(){
        log.info("Drink top shelf potions");
        topShelf.forEach(Potion::drink);
        log.info("Drink bottom shelf potions");
        bottomShelf.forEach(Potion::drink);
    }
}

package com.tenstone.leet.patterns.structural.flyweight;

import com.google.common.collect.Maps;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * Then the actual Flyweight class PotionFactory, which is the factory for creating potions.
 *
 * @author liuyuancheng
 */
public class PotionFactory {

    private Map<PotionType, Potion> potions = Maps.newHashMap();

    public PotionFactory() {
        // EnumMap的Key为枚举类型，没有空间浪费，效率高
        potions = new EnumMap<PotionType, Potion>(PotionType.class);
    }

    public Potion createPotion(PotionType type) {
        var potion = potions.get(type);
        if (Objects.isNull(potion)) {
            switch (type) {
                case HOLY_WATER:
                    potion = new HolyWaterPotion();
                    potions.put(type, potion);
                    break;
                case HEALING:
                    potion = new HealingPotion();
                    potions.put(type, potion);
                    break;
                case INVISIBILITY:
                    potion = new InvisibilityPotion();
                    potions.put(type, potion);
                    break;
                default:
                    break;
            }
        }
        return potion;
    }
}

package com.tenstone.leet.patterns.behavior.strategy;

/**
 * Created by liuyuancheng on 2021/7/17  <br/>
 */
public class Hand {

    public static final int HANDVALUE_GUU = 0; // 石头
    public static final int HANDVALUE_CHO = 1; // 剪刀
    public static final int HANDVALUE_PAA = 2; // 布

    public static final String[] name = {
            "石头", "剪刀", "布"
    };

    /**
     * singleton
     */
    public static final Hand[] hand = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA)
    };

    /**
     * 静态工厂方法
     *
     * @param handValue
     * @return
     */
    public static Hand getHand(int handValue) {
        return hand[handValue];
    }

    private final int handValue;

    /**
     * 私有构造方法
     *
     * @param handValue
     */
    private Hand(int handValue) {
        this.handValue = handValue;
    }

    public boolean isStrongThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name[handValue];
    }
}

package com.tenstone.leet.patterns.strategy;

import java.util.Random;

/**
 * 猜拳策略：如果赢了跟上次出一样，如果输了随机出
 *
 * Created by liuyuancheng on 2021/7/17  <br/>
 */
public class WinningStrategy implements Strategy {

    private final Random random;

    private boolean won = false;

    private Hand prevHand;

    public WinningStrategy(int seed){
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if(!won){
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}

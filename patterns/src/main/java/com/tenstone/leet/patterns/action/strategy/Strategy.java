package com.tenstone.leet.patterns.action.strategy;

/**
 * 策略接口
 *
 * Created by liuyuancheng on 2021/7/17  <br/>
 */
public interface Strategy {

    Hand nextHand();

    void study(boolean win);
}

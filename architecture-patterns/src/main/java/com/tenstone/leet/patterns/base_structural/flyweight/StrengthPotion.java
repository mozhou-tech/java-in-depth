package com.tenstone.leet.patterns.base_structural.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class StrengthPotion implements Potion{
    @Override
    public void drink() {
        log.info("You become strength. (Potion={})", System.identityHashCode(this));
    }
}

package com.tenstone.leet.patterns.structural.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class PoisonPotion implements Potion {
    @Override
    public void drink() {
        log.info("You poison to die. (Potion={})", System.identityHashCode(this));
    }
}

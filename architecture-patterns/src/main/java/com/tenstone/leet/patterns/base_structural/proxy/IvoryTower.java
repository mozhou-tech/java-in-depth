package com.tenstone.leet.patterns.base_structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class IvoryTower implements IWizardTower {
    @Override
    public void enter(Wizard wizard) {
        log.info("{} enters the tower.", wizard);
    }
}

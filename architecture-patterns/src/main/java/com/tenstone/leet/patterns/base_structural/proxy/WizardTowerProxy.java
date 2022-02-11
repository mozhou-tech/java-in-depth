package com.tenstone.leet.patterns.base_structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * We have the WizardTowerProxy to add access control to WizardTower.
 *
 * @author liuyuancheng
 */
@Slf4j
public class WizardTowerProxy implements IWizardTower {

    private static final int NUM_WIZARDS_ALLOWED = 3;

    private int numWizards;

    private IWizardTower tower;

    public WizardTowerProxy(IWizardTower tower) {
        this.tower = tower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED) {
            tower.enter(wizard);
            numWizards++;
        } else {
            log.info("{} is not allowed to enter.",wizard);
        }
    }
}

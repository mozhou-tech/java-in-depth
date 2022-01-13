package com.tenstone.leet.patterns.behavioral.state;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class PeacefulState implements State {

    public PeacefulState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    private Mammoth mammoth;

    @Override
    public void onEnterState() {
        log.info("{} is claim and peaceful.", mammoth);
    }

    @Override
    public void observe() {
        log.info("{} claims down.", mammoth);
    }
}

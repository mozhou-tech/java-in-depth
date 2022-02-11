package com.tenstone.leet.patterns.base_behavioral.state;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class AngryState implements State {

    public AngryState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    private Mammoth mammoth;


    @Override
    public void onEnterState() {
        log.info("{} is furious!",mammoth);
    }

    @Override
    public void observe() {
        log.info("{} gets angry",mammoth);
    }
}

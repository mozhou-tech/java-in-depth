package com.tenstone.leet.patterns.base_behavioral.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        log.info("Binary String: {}",Integer.toBinaryString(subject.getState()));
    }
}

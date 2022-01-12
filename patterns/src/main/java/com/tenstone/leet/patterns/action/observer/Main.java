package com.tenstone.leet.patterns.action.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 为避免卡壳和提高性能，观察者一般采用异步方式
 * 一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
 *
 * @author liuyuancheng
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexaObserver(subject);
        new BinaryObserver(subject);
        new OctalObserver(subject);
        log.info("First state change: 15");
        subject.setState(15);
        log.info("Second state change: 10");
        subject.setState(10);
    }
}

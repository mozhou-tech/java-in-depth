package com.tenstone.leet.patterns.behavioral.memento;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 应用实例： 1、后悔药。 2、打游戏时的存档。 3、Windows 里的 ctrl + z。 4、IE 中的后退。 5、数据库的事务管理。
 * 优点： 1、给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态。 2、实现了信息的封装，使得用户不需要关心状态的保存细节。
 * 缺点：消耗资源。如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。
 * 使用场景： 1、需要保存/恢复数据的相关状态场景。 2、提供一个可回滚的操作。
 *
 * @author liuyuancheng
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("#1");
        originator.setState("#2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("#3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("#4");


        log.info("Current State: {}", originator.getState());
        originator.recoverStateFromMemento(careTaker.get(0));
        log.info("First saved State: {}", originator.getState());
        originator.recoverStateFromMemento(careTaker.get(1));
        log.info("Second saved State: {}", originator.getState());
    }

}

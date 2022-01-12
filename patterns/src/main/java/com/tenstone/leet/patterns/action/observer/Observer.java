package com.tenstone.leet.patterns.action.observer;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
public abstract class Observer {

    /**
     * 观察者绑定的Subject
     */
    protected Subject subject;

    /**
     * 抽象方法：subject的状态发生变化时，触发观察者的事件
     */
    public abstract void update();
}

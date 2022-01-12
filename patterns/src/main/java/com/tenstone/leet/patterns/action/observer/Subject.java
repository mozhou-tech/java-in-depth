package com.tenstone.leet.patterns.action.observer;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
public class Subject {

    private List<Observer> observers = Lists.newArrayList();

    private int state;

    public int getState() {
        return state;
    }

    /**
     * Subject 管理的状态，通过notifyAllObservers告知观察者
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }

    /**
     * 添加新的观察者
     *
     * @param observer
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 通知所有观察者更新状态
     */
    public void notifyAllObservers(){
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}

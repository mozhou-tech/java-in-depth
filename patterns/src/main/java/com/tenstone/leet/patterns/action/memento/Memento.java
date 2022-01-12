package com.tenstone.leet.patterns.action.memento;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 用于保存状态
 *
 * @author liuyuancheng
 */
public class Memento {

    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

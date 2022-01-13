package com.tenstone.leet.patterns.behavior.memento;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 用于保存状态：整合Originator角色的内部信息（Memento保存了这些信息，但并不会将其公开）
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

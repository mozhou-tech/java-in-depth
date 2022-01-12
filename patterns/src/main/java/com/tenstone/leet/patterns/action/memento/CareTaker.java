package com.tenstone.leet.patterns.action.memento;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 看护人：负责从备忘录恢复状态
 *
 * @author liuyuancheng
 */
public class CareTaker {

    private List<Memento> momentoList = Lists.newArrayList();

    /**
     * 保存状态
     * @param state
     */
    public void add(Memento state){
        momentoList.add(state);
    }

    /**
     * 按索引获取状态
     * @param index
     * @return
     */
    public Memento get(int index){
        return momentoList.get(index);
    }

}

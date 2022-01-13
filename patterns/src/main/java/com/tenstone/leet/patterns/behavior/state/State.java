package com.tenstone.leet.patterns.behavior.state;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * 状态抽象类
 *
 * @author liuyuancheng
 */
public interface State {

    /**
     * 监听状态进入
     */
    void onEnterState();

    /**
     * 查看状态
     */
    void observe();
}

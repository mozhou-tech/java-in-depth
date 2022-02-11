package com.tenstone.leet.patterns.base_behavioral.state;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * 猛犸象
 *
 * @author liuyuancheng
 */
public class Mammoth {

    private State state;

    public Mammoth() {
        // 默认状态下，猛犸象很平静
        this.state = new PeacefulState(this);
    }

    /**
     * 过了一段时间，猛犸象的状态发生变化
     */
    public void timePasses() {
        if (state.getClass().equals(PeacefulState.class)) {
            changeStateTo(new AngryState(this));
        } else {
            changeStateTo(new PeacefulState(this));
        }
    }

    private void changeStateTo(State state) {
        this.state = state;
        this.state.onEnterState();
    }

    public void observe() {
        this.state.observe();
    }

    @Override
    public String toString() {
        return "The Mammoth";
    }
}

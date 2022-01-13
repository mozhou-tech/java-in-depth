package com.tenstone.leet.patterns.behavioral.memento;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 生成者：保存状态到备忘录，以及从备忘录中恢复状态
 *
 * @author liuyuancheng
 */
public class Originator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    /**
     * 讲当前状态保存至备忘录
     *
     * @return
     */
    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    /**
     * 从备忘录恢复状态
     *
     * @param memento
     */
    public void recoverStateFromMemento(Memento memento){
        state = memento.getState();
    }
}

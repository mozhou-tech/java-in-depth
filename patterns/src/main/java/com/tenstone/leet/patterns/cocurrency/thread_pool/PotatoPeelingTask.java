package com.tenstone.leet.patterns.cocurrency.thread_pool;

/**
 * Created by liuyuancheng on 2022/1/17  <br/>
 *
 * @author liuyuancheng
 */
public class PotatoPeelingTask extends Task{

    private static int TIME_PER_POTATO = 200;

    public PotatoPeelingTask(int numPotatoes) {
        super(numPotatoes* TIME_PER_POTATO);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}

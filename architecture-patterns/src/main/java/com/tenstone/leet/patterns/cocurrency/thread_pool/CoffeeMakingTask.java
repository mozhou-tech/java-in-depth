package com.tenstone.leet.patterns.cocurrency.thread_pool;

/**
 * Created by liuyuancheng on 2022/1/17  <br/>
 *
 * @author liuyuancheng
 */
public class CoffeeMakingTask extends Task {
    private static int TIME_PER_CUP = 100;

    public CoffeeMakingTask(int numCups) {
        super(numCups * TIME_PER_CUP);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}

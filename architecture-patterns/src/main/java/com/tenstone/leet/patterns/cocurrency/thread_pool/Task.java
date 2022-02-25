package com.tenstone.leet.patterns.cocurrency.thread_pool;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2022/1/17  <br/>
 *
 * @author liuyuancheng
 */
@Data
public abstract class Task {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    private int id;

    private int timeMs;

    public Task(int timeMs) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.timeMs = timeMs;
    }

    @Override
    public String toString() {
        return String.format("id=%d timeMs=%d",id,timeMs);
    }
}

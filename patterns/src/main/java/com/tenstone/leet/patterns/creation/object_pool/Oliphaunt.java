package com.tenstone.leet.patterns.creation.object_pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 猛犸象：一个大对象，创建的代价很高
 *
 * @author liuyuancheng
 */
public class Oliphaunt {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private int id;

    public Oliphaunt(){
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Oliphaunt id=%d", id);
    }
}

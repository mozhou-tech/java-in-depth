package com.tenstone.leet.patterns.creation.object_pool;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        var pool = new OliphauntPool();
        var oliphaunt1 = pool.checkOut();
        var oliphaunt2 = pool.checkOut();
        var oliphaunt3 = pool.checkOut();
        pool.checkIn(oliphaunt1);
        pool.checkIn(oliphaunt2);
        var oliphaunt4 = pool.checkOut();
        var oliphaunt5 = pool.checkOut();
    }
}

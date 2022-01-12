package com.tenstone.leet.patterns.creation.object_pool;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * The object pool pattern is a software creational design pattern that uses a set of initialized objects
 * kept ready to use – a "pool" – rather than allocating and destroying them on demand.
 * 对象池（英语：object pool pattern）是一种设计模式。一个对象池包含一组已经初始化过且可以使用的对象，而可以在有需求时创建和销毁对象。
 * 池的用户可以从池子中取得对象，对其进行操作处理，并在不需要时归还给池子而非直接销毁它。这是一种特殊的工厂对象。
 *
 * https://java-design-patterns.com/patterns/object-pool/
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
        System.out.println(pool);
        var oliphaunt4 = pool.checkOut();
        var oliphaunt5 = pool.checkOut();
        System.out.println(pool);
    }
}

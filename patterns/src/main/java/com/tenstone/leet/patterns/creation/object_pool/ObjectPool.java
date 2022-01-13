package com.tenstone.leet.patterns.creation.object_pool;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * Created by liuyuancheng on 2022/1/12  <br/>
 * 对象池抽象方法
 *
 * @author liuyuancheng
 */
@Slf4j
public abstract class ObjectPool<T> {

    /**
     * 可用对象池
     */
    private final Set<T> available = Sets.newHashSet();

    /**
     * 使用中的对象
     */
    private final Set<T> inUse = Sets.newHashSet();

    protected abstract T create();

    /**
     * 检出对象（取出）
     *
     * @return
     */
    public synchronized T checkOut() {
        if (available.isEmpty()) {
            available.add(create());
        }
        var instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    /**
     * 检入对象（放回）
     *
     * @param instance
     */
    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}

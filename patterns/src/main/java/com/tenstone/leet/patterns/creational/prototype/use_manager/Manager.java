package com.tenstone.leet.patterns.creational.prototype.use_manager;

import java.util.HashMap;

/**
 * Created by liuyuancheng on 2021/7/12  <br/>
 */
public class Manager {

    private final HashMap<String, ProductPrototype> showcase = new HashMap<>();

    /**
     * 存储复制出的原型
     *
     * @param name
     * @param proto
     */
    public void register(String name, ProductPrototype proto) {
        showcase.put(name, proto);
    }

    public ProductPrototype create(String protoname) {
        ProductPrototype p = showcase.get(protoname);
        return p.createClone();
    }
}

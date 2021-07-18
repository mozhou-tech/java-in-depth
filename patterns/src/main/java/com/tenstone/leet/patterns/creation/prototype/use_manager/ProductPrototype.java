package com.tenstone.leet.patterns.creation.prototype.use_manager;

/**
 * 原型
 * <p>
 * Created by liuyuancheng on 2021/7/12  <br/>
 */
public interface ProductPrototype extends Cloneable {

    void use(String s);

    ProductPrototype createClone();

}

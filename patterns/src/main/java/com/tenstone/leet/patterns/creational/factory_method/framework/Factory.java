package com.tenstone.leet.patterns.creational.factory_method.framework;

/**
 * Created by liuyuancheng on 2021/7/11  <br/>
 */
public abstract class Factory {

    /**
     * 生产产品
     *
     * @param owner
     * @return
     */
    public final Product create(String owner){
        // 调用子类中的方法，创建产品
        Product p = createProduct(owner);
        // 注册产品
        registerProduct(p);
        return p;
    }

    protected abstract void registerProduct(Product p);

    protected abstract Product createProduct(String owner);

    public abstract String readRegisterBook();

}

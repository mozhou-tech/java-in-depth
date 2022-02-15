package com.tenstone.jdk.spi;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class SpiDemoImpl2 implements SpiDemoInterface{
    @Override
    public String print() {
        return this.getClass().getName();
    }
}

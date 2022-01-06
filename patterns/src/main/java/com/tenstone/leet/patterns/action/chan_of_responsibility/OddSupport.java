package com.tenstone.leet.patterns.action.chan_of_responsibility;

/**
 * 解决问题编号为奇数的问题
 *
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
public class OddSupport extends Support{

    public OddSupport(String name){
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }

}

package com.tenstone.leet.patterns.action.chan_of_responsibility;

/**
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

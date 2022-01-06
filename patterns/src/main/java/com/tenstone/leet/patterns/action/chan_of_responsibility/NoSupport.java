package com.tenstone.leet.patterns.action.chan_of_responsibility;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}

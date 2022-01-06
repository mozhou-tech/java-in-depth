package com.tenstone.leet.patterns.action.chan_of_responsibility;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
public class SpecialSupport extends Support{
    private int number;

    public SpecialSupport(String name,int number){
        super(name);
        this.number = number;
    }


    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}

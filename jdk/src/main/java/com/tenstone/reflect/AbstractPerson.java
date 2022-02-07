package com.tenstone.reflect;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
@Getter
public abstract class AbstractPerson implements Serializable {

    private String name;

    public AbstractPerson() {
    }

    public AbstractPerson(String name) {
        this.name = name;
    }
}

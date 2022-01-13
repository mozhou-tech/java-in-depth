package com.tenstone.leet.patterns.behavioral.visitor;

/**
 * 访问者元素
 * Created by liuyuancheng on 2022/1/4  <br/>
 *
 * @author liuyuancheng
 */
public interface Element {

    void accept(Visitor visitor);

}

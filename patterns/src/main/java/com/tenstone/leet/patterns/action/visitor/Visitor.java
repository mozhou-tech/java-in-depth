package com.tenstone.leet.patterns.action.visitor;

/**
 * Created by liuyuancheng on 2022/1/4  <br/>
 *
 * @author liuyuancheng
 */
public abstract class Visitor {
    abstract void visit(File file);

    abstract void visit(Directory directory);
}

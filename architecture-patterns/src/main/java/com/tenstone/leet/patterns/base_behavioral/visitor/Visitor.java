package com.tenstone.leet.patterns.base_behavioral.visitor;

/**
 * Created by liuyuancheng on 2022/1/4  <br/>
 *
 * @author liuyuancheng
 */
public abstract class Visitor {

    public abstract void visit(File file);

    public abstract void visit(Directory directory);

}

package com.tenstone.leet.patterns.behavioral.interpreter.node;

import com.tenstone.leet.patterns.behavioral.interpreter.Context;
import com.tenstone.leet.patterns.behavioral.interpreter.ParseException;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
public abstract class Node {

    /**
     * 语法解析处理
     *
     * @param context
     * @throws ParseException
     */
    public abstract void parse(Context context) throws ParseException;
}

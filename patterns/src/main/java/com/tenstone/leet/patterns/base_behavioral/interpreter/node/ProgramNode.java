package com.tenstone.leet.patterns.base_behavioral.interpreter.node;

import com.tenstone.leet.patterns.base_behavioral.interpreter.Context;
import com.tenstone.leet.patterns.base_behavioral.interpreter.ParseException;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
public class ProgramNode extends Node {

    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + ']';
    }
}

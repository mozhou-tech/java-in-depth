package com.tenstone.leet.patterns.base_behavioral.interpreter.node;

import com.tenstone.leet.patterns.base_behavioral.interpreter.Context;
import com.tenstone.leet.patterns.base_behavioral.interpreter.ParseException;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
public class CommandNode extends Node {

    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if(context.currentToken().equals("repeat")){
            node = new RepeatCommandNode();
            node.parse(context);
        }else{
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        return node.toString();
    }
}

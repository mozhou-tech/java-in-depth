package com.tenstone.leet.patterns.behavioral.interpreter.node;

import com.tenstone.leet.patterns.behavioral.interpreter.Context;
import com.tenstone.leet.patterns.behavioral.interpreter.ParseException;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
public class CommandListNode extends Node {

    private List<Node> list = Lists.newArrayList();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("missing 'end'.");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

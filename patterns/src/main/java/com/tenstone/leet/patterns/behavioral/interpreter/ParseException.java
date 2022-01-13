package com.tenstone.leet.patterns.behavioral.interpreter;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
public class ParseException extends RuntimeException {
    public ParseException(String s) {
        super(s);
    }
}

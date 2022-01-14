package com.tenstone.leet.patterns.behavioral.interpreter;

import java.util.StringTokenizer;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * 为语法解析提供必要信息
 *
 * @author liuyuancheng
 */
public class Context {

    // 构造一个用来解析 str 的 StringTokenizer 对象。java 默认的分隔符是空格("")、制表符(\t)、换行符(\n)、回车符(\r)。
    private StringTokenizer tokenizer;

    private String currentToken;

    public Context(String text) {
        this.tokenizer = new StringTokenizer(text);
        nextToken();
    }

    /**
     * 获取下一标记
     *
     * @return
     */
    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    /**
     * 先检查当前标记，然后获取下一个标记
     *
     * @param token
     */
    public void skipToken(String token) {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.");
        }
        nextToken();
    }

    /**
     * 获取当前标记
     *
     * @return
     */
    public String currentToken() {
        return currentToken;
    }

    /**
     * 获取当前标记对应的数值
     *
     * @return
     */
    public int currentNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }
}

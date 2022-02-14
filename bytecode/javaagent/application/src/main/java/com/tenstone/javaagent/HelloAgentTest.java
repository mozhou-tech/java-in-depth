package com.tenstone.javaagent;

import org.junit.jupiter.api.Test;

/**
 * Created by liuyuancheng on 2022/2/13  <br/>
 *
 * @author liuyuancheng
 */
public class HelloAgentTest {

    // vm option:   -javaagent:xxx.jar=name=lisi&age=30
    public static void main(String[] args) {
        System.err.println("application: TestHelloAgent main 方法");
        hello();
    }

    public static void hello() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("application: HelloAgentTest hello() output");
    }
}

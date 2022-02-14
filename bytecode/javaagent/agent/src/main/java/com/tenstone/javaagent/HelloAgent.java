package com.tenstone.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * Created by liuyuancheng on 2022/2/13  <br/>
 *
 * @author liuyuancheng
 */
public class HelloAgent {

    public static void premain(String arg, Instrumentation instrumentation) throws ClassNotFoundException {
        // 此处为-javaagent参数中指定的参数
        System.out.println("agent: 装载成功 方法 premain 参数：" + arg);
        // 添加Transformer（遍历处理JVM加载的所有的类）
        instrumentation.addTransformer(new FirstAgent());
    }
}

package com.tenstone.javassist.hotswap;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import javassist.*;
import javassist.util.HotSwapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class HotSwapDemo {

    private static String path = HotSwapDemo.class.getResource("").getPath();

    private static File backupfile = new File(path + "/HelloWorld.class");

    /**
     * need adding -agentlib:jdwp=transport=dt_socket,address=localhost:8000,server=y,suspend=n
     * 否则会Connection Refused
     */
    public static void main(String[] args) throws IllegalConnectorArgumentsException, IOException, NotFoundException, CannotCompileException {
        // 必须先实例化，否则报错
        System.out.println("before ==========================================");
        new HelloWorld().print();
        HotSwapper hs = new HotSwapper(8000);
        byte[] backupBytes = new byte[(int) backupfile.length()];
        // 读取class
        new FileInputStream(backupfile).read(backupBytes);
        byte[] afterModifierBytes = modifier();
        System.out.println("modified ==========================================");
        hs.reload("com.tenstone.javassist.hotswap.HelloWorld", afterModifierBytes);
        new HelloWorld().print();
        System.out.println("restored ==========================================");
        hs.reload("com.tenstone.javassist.hotswap.HelloWorld", backupBytes);
        new HelloWorld().print();
    }

    private static byte[] modifier() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.tenstone.javassist.hotswap.HelloWorld");
        final CtMethod printMethod = cc.getDeclaredMethod("print");
        printMethod.insertAfter("System.out.println(\"inserted logging code .....\");");
        return cc.toBytecode();
    }

}

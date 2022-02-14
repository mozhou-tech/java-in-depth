package com.tenstone.javaagent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by liuyuancheng on 2022/2/13  <br/>
 *
 * @author liuyuancheng
 */
public class FirstAgent implements ClassFileTransformer {

    public final String injectedClassName = "com.tenstone.javaagent.HelloAgentTest";

    public final String methodName = "hello";

    /**
     * agent代码植入
     *
     * @param loader
     * @param className
     * @param classBeingRedefined
     * @param protectionDomain
     * @param classfileBuffer
     * @return
     * @throws IllegalClassFormatException
     */
    @Override
    public synchronized byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        ClassPool pool = ClassPool.getDefault();
        byte[] transformed = null;
        if (className.equals(injectedClassName)) {
            CtClass ctclass;
            long start = System.nanoTime();
            try {
                // 使用全称,用于取得字节码类<使用javassist>
                ctclass = pool.get(injectedClassName);
                System.out.println("agent: begin===" + ctclass.getName());
                // 得到这方法实例
                CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);
                System.out.println("agent: pre inject action.");
                ctmethod.insertBefore("System.out.println(11111111);");
                transformed = ctclass.toBytecode();
            } catch (CannotCompileException | IOException | NotFoundException e) {
                e.printStackTrace();
            } finally {
                System.out.println("agent: " + injectedClassName);
                System.out.println("agent: className took:" + (System.currentTimeMillis() - start));
            }

        }
        return transformed;
    }
}

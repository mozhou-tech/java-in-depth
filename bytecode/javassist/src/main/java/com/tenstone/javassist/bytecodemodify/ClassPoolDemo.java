package com.tenstone.javassist.bytecodemodify;

import javassist.*;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class ClassPoolDemo {

    public int f(int i) {
        return i + 1;
    }

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass cc = pool.get("com.tenstone.javassist.bytecodemodify.ClassPoolDemo");
        try {
            cc.getDeclaredMethod("g");
            System.out.println("g() is already defined in sample.Test.");
        } catch (NotFoundException e) {
            /* getDeclaredMethod() throws an exception if g()
             * is not defined in sample.Test.
             */
            CtMethod fMethod = cc.getDeclaredMethod("f");
            CtMethod gMethod = CtNewMethod.copy(fMethod, "g", cc, null);
            cc.addMethod(gMethod);
            // update the class file
            String path = System.getProperty("user.dir") + "/bytecode/javassist/src/main/java";
            cc.writeFile(path);
            System.out.println("g() was added.");
        }
    }
}

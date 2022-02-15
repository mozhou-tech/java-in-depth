package com.tenstone.javassist.reflect;

import javassist.tools.reflect.Loader;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class ReflectDemo {

    public static void main(String[] args) throws Throwable {
        Loader cl = (Loader) ReflectDemo.class.getClassLoader();
        cl.makeReflective("com.tenstone.javassist.reflect.Person",
                "com.tenstone.javassist.reflect.VerboseMetaobj",
                "javassist.tools.reflect.ClassMetaobject");

        cl.run("com.tenstone.javassist.reflect.Person", args);
    }

}

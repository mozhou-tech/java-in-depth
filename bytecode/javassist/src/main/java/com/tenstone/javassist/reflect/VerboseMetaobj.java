package com.tenstone.javassist.reflect;

import javassist.tools.reflect.Metaobject;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class VerboseMetaobj extends Metaobject {
    public VerboseMetaobj(Object self, Object[] args) {
        super(self, args);
        System.out.println("** constructed: " + self.getClass().getName());
    }

    @Override
    public Object trapFieldRead(String name) {
        System.out.println("** field read: " + name);
        return super.trapFieldRead(name);
    }

    @Override
    public void trapFieldWrite(String name, Object value) {
        System.out.println("** field write: " + name);
        super.trapFieldWrite(name, value);
    }

    @Override
    public Object trapMethodcall(int identifier, Object[] args)
            throws Throwable {
        System.out.println("** trap: " + getMethodName(identifier) + "() in "
                + getClassMetaobject().getName());
        return super.trapMethodcall(identifier, args);
    }
}

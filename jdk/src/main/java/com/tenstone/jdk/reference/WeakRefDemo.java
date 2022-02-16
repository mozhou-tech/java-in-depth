package com.tenstone.jdk.reference;

import java.lang.ref.WeakReference;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class WeakRefDemo {
    public static void main(String[] args) {
        WeakReference<Student> stu = new WeakReference<Student>(new Student("xiaosan",21));
    }
}

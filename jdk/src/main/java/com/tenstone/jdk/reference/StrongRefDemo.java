package com.tenstone.jdk.reference;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class StrongRefDemo {

    public static void main(String[] args) {
        Student student = new Student("xiaosan",22);
        student = null;
        System.gc();
        System.out.println(student);
    }

}

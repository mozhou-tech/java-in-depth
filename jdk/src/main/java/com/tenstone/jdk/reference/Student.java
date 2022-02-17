package com.tenstone.jdk.reference;

import lombok.Data;

import java.util.Arrays;

/**
 * Created by liuyuancheng on 2022/2/16  <br/>
 *
 * @author liuyuancheng
 */
@Data
public class Student {
    private String name;
    private Integer age;

    private byte[] mem = new byte[1024 * 1024];

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

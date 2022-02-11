package com.tenstone.jdk.io;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
@Data
public class MyClass implements Serializable {

    private String name = "zhangsan";

    private Integer age = 11;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

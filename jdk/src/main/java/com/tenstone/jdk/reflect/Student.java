package com.tenstone.jdk.reflect;

import lombok.Getter;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
@Getter
public class Student extends AbstractPerson {
    private Integer age;
    private Boolean sex;

    public Student(Integer age, Boolean sex) {
        this.age = age;
        this.sex = sex;
    }

    public Student(String name, Integer age, Boolean sex) {
        super(name);
        this.age = age;
        this.sex = sex;
    }
}

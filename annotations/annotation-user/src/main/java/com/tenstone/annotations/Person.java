package com.tenstone.annotations;

/**
 * Created by liuyuancheng on 2022/2/11  <br/>
 *
 * @author liuyuancheng
 */
public class Person {

    private int age;

    private String name;


    public int getAge() {
        return age;
    }

    @BuilderProperty
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @BuilderProperty
    public void setName(String name) {
        this.name = name;
    }
}

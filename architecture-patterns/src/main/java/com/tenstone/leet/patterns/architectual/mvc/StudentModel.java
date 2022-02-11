package com.tenstone.leet.patterns.architectual.mvc;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 *
 * @author liuyuancheng
 */
public class StudentModel {

    private String rollNo;

    private String name;

    public StudentModel(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

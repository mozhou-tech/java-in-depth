package com.tenstone.leet.calcite.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liuyuancheng on 2022/1/24  <br/>
 *
 * @author liuyuancheng
 */
public class Student implements Comparable<Student>{
    private long id;

    private String name;

    private long cid;

    public Student(ResultSet rs) {
        try {
            id = rs.getLong("id");
            name = rs.getString("name");
            cid = rs.getLong("cid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}

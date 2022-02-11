package com.tenstone.leet.patterns.architectual.mvc;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 *
 * @author liuyuancheng
 */
public class StudentController {

    private StudentModel model;

    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}

package com.tenstone.leet.patterns.architectual.mvc;

/**
 * Created by liuyuancheng on 2022/1/14  <br/>
 *
 * @author liuyuancheng
 */
public class MvcPatternDemo {

    public static void main(String[] args) {
        StudentModel model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        // 更新view
        controller.updateView();
        // 更新模型数据
        controller.setStudentName("John");
        // 更新view
        controller.updateView();
    }

    private static StudentModel retrieveStudentFromDatabase() {
        return new StudentModel("Robert", "10");
    }

}

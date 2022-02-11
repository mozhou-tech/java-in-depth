package com.tenstone.leet.patterns.base_behavioral.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by liuyuancheng on 2022/1/9  <br/>
 *
 * @author liuyuancheng
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckbox checkGuest;

    private ColleagueCheckbox checkLogin;

    private ColleagueTextField textUser;

    private ColleagueTextField textPass;

    private ColleagueButton buttonOk;

    private ColleagueButton buttonCancel;

    /**
     * 初始化登录窗口
     *
     * @param title
     */
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4, 2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username: "));
        add(textUser);
        add(new Label("Password: "));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        // 设置初始的启用/禁用状态
        colleagueChanged();
        pack();
        setVisible(true);
    }

    /**
     * 创建共事者
     */
    @Override
    public void createColleagues() {
        // 生成Colleagues
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // 设置Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        // 设置Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    /**
     * 接收来自于Colleage的通知然后判断各Colleague的启用/禁用状态
     * 1. 共事者状态变化时调用本方法（checkBox）
     * 2. 共事者文本变化时调用本方法（textBox）
     */
    @Override
    public void colleagueChanged() {
        System.out.println("colleagueChanged-checkGuest: state="+ checkGuest.getState());
        if (checkGuest.getState()) {
            // Guest Mode
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            // Login Mode
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    /**
     * 共事者变化时，检查用户输入内容，并以此修改状态
     */
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}

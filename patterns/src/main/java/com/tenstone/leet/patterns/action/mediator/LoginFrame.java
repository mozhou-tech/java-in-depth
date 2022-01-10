package com.tenstone.leet.patterns.action.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by liuyuancheng on 2022/1/9  <br/>
 *
 * @author liuyuancheng
 */
public class LoginFrame extends Frame implements ActionListener,Mediator {

    private ColleagueCheckbox checkGuest;

    private ColleagueCheckbox checkLogin;

    private ColleagueTextField textUser;

    private ColleagueTextField textPass;

    private ColleagueButton buttonOk;

    private ColleagueButton buttonCancel;


    public LoginFrame(String title){
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4,2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username: "));
        add(textUser);
        add(new Label("Password: "));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        pack();
        show();
    }

    @Override
    public void createColleagues() {

    }

    @Override
    public void colleagueChanged() {

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

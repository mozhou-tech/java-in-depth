package com.tenstone.leet.patterns.structural.proxy;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 * Imagine a tower where the local wizards go to study their spells. The ivory tower can only be accessed through a proxy
 * which ensures that only the first three wizards can enter. Here the proxy represents the functionality of the tower and adds access control to it.
 *
 *
 * Using the proxy pattern, a class represents the functionality of another class.
 *
 * @author liuyuancheng
 */
public class Main {
    public static void main(String[] args) {
        var proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }
}

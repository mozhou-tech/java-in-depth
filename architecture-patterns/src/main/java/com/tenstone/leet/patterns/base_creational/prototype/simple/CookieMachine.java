package com.tenstone.leet.patterns.base_creational.prototype.simple;

/**
 * Created by liuyuancheng on 2021/7/13  <br/>
 */
public class CookieMachine {

    private final Cookie cookie;//cookie必须是可复制的

    public CookieMachine(Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie makeCookie() {
        try {
            return (Cookie) cookie.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String args[]) {
        Cookie tempCookie = null;
        Cookie prot = new CoconutCookie();
        CookieMachine cm = new CookieMachine(prot); //设置原型
        for (int i = 0; i < 100; i++) {
            tempCookie = cm.makeCookie();//通过复制原型返回多个cookie
        }
    }
}

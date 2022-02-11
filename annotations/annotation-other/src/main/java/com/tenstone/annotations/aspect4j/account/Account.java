package com.tenstone.annotations.aspect4j.account;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
public class Account {

    int balance = 20;

    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance = balance - amount;
        return true;
    }
}

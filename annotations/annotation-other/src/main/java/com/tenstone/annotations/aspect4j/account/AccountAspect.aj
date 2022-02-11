package com.tenstone.annotations.aspect4j.account;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
public aspect AccountAspect {

    final int MIN_BALANCE = 10;

    pointcut callWithDraw(int amount, Account acc): call(boolean com.tenstone.aspect4j.account.Account.withdraw(int)) && args(amount) && target(acc);

    before(int amount, Account acc): callWithDraw(amount, acc) {
        System.out.println("before...");
    }

    boolean around(int amount, Account acc): callWithDraw(amount, acc) {
        if (acc.balance < amount) {
            return false;
        }
        return proceed(amount, acc);
    }

    after(int amount, Account balance): callWithDraw(amount, balance) {
        System.out.println("after...");
    }

}

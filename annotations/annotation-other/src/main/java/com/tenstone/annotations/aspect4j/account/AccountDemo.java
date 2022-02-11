package com.tenstone.annotations.aspect4j.account;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
public class AccountDemo {

    public static void main(String[] args) {
        // 账户余额20
        Account account = new Account();
        // 提取5 - 成功
        System.out.println(account.withdraw(5));
        // 提取20 - 余额不足 失败
        System.out.println(account.withdraw(20));
    }

}

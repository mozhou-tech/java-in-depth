package com.tenstone.aspect4j;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
public class AccountDemo {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account.withdraw(5));
        System.out.println(account.withdraw(100));
    }
}

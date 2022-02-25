package com.tenstone.leet.patterns.base_creational.builder.inner_class;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = BankAccount.builder(1)
                .atBranch("branch")
                .atRate(1.0)
                .openingBalance(11.11)
                .withOwner("myname")
                .build();
        System.out.println(bankAccount);
    }
}

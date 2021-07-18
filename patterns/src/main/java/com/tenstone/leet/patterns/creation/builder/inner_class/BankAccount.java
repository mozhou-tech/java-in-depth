package com.tenstone.leet.patterns.creation.builder.inner_class;

/**
 * Created by liuyuancheng on 2021/7/14  <br/>
 */
public class BankAccount {

    private long accountNumber; //This is important, so we'll pass it to the constructor.
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    public static Builder builder(long accountNumber) {
        return new Builder(accountNumber);
    }

    public static class Builder {

        private final long accountNumber; //This is important, so we'll pass it to the constructor.

        private String owner;

        private String branch;

        private double balance;

        private double interestRate;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;

            return this;  //By returning the builder each time, we can create a fluent interface.
        }

        public Builder atBranch(String branch) {
            this.branch = branch;

            return this;
        }

        public Builder openingBalance(double balance) {
            this.balance = balance;

            return this;
        }

        public Builder atRate(double interestRate) {
            this.interestRate = interestRate;

            return this;
        }

        public BankAccount build() {
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
            BankAccount account = new BankAccount();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;
            return account;
        }
    }


    @Override
    public String toString() {
        return String.format("accountNumber=%s,owner=%s,branch=%s,balance=%s,interestRate=%s"
                , accountNumber
                , owner, branch, balance, interestRate
        );
    }

    //Fields omitted for brevity.
    private BankAccount() {
        //Constructor is now private.
    }
}

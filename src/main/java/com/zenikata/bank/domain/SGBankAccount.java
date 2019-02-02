package com.zenikata.bank.domain;

public class SGBankAccount implements BankAccount {
    private int balance;

    public void deposit(Money money) {
        balance += money.amount();
    }

    public void withdraw(Money amountToWithdraw) {
        balance -= amountToWithdraw.amount();
    }

    public int balance() {
        return balance;
    }
}

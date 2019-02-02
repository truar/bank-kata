package com.zenikata.bank.domain;

public class SGBankAccount implements BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(Integer amountToWithdraw) {
        balance -= amountToWithdraw;
    }

    public int balance() {
        return balance;
    }
}

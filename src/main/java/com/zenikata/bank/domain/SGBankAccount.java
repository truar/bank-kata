package com.zenikata.bank.domain;

public class SGBankAccount implements BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public int balance() {
        return balance;
    }
}

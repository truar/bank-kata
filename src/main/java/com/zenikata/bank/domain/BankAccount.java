package com.zenikata.bank.domain;

public interface BankAccount {

    int balance();

    void deposit(int amount);

    void withdraw(Integer amountToWithdraw);
}

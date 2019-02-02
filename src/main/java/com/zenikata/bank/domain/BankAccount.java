package com.zenikata.bank.domain;

public interface BankAccount {

    int balance();

    void deposit(Money amount);

    void withdraw(Money amountToWithdraw);
}

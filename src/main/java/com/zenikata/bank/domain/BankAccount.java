package com.zenikata.bank.domain;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccount {

    BigDecimal balance();

    void deposit(Money amountToDepose);

    void withdraw(Money amountToWithdraw);

    List<Transaction> transactions();
}

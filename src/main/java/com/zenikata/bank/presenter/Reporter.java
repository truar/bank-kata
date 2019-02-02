package com.zenikata.bank.presenter;

import com.zenikata.bank.domain.BankAccount;

public interface Reporter {
    String print(BankAccount bankAccount);
}

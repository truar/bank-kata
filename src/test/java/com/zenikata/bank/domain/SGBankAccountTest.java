package com.zenikata.bank.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SGBankAccountTest {

    private BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new SGBankAccount();
    }

    @Test
    public void shouldDepositMoney() {
        bankAccount.deposit(Money.fromInteger(10));
        assertThat(bankAccount.balance()).isEqualTo(Money.fromInteger(10).amount());
    }

    @Test
    public void shouldWithdrawMoney() {
        bankAccount.deposit(Money.fromInteger(10));
        bankAccount.withdraw(Money.fromInteger(5));
        assertThat(bankAccount.balance()).isEqualTo(Money.fromInteger(5).amount());
    }

}
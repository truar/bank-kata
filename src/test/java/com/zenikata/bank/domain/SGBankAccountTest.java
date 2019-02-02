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
        bankAccount.deposit(10);
        assertThat(bankAccount.balance()).isEqualTo(10);
    }
}
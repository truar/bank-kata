package com.zenikata.bank.domain;

import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class SGBankAccountTest {

    private BankAccount bankAccount;

    private Clock clock = new Clock();

    @Before
    public void setUp() {
        bankAccount = new SGBankAccount(clock);
    }

    @Test
    public void shouldDepositMoney() {
        bankAccount.deposit(Money.fromInteger(10));
        assertThat(bankAccount.balance()).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void shouldWithdrawMoney() {
        bankAccount.deposit(Money.fromInteger(10));
        bankAccount.withdraw(Money.fromInteger(5));
        assertThat(bankAccount.balance()).isEqualTo(new BigDecimal(5));
    }

    @Test
    public void shouldAddTheOperationToTheTransactionHistory() {
        assertThat(bankAccount.transactions()).hasSize(0);
        bankAccount.deposit(Money.fromInteger(10));
        assertThat(bankAccount.transactions()).hasSize(1);
        bankAccount.withdraw(Money.fromInteger(10));
        assertThat(bankAccount.transactions()).hasSize(2);

    }

}
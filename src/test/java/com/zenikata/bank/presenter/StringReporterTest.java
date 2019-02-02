package com.zenikata.bank.presenter;

import com.zenikata.bank.domain.BankAccount;
import com.zenikata.bank.domain.Clock;
import com.zenikata.bank.domain.Money;
import com.zenikata.bank.domain.SGBankAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StringReporterTest {

    private Reporter reporter = new StringReporter();
    private BankAccount bankAccount;
    @Mock
    private Clock clock;

    private final static LocalDateTime dateTime = LocalDateTime.of(2019, 02, 02, 14, 5, 30);

    private final static String expectedReport = "Your current balance is: 0.00\n" +
            "DEPOSIT   |10.00     |02/02/2019 14:05:30|\n" +
            "WITHDRAW  |-10.00    |02/02/2019 14:05:30|\n";

    @Before
    public void setUp() {
        when(clock.now()).thenReturn(dateTime);
        bankAccount = new SGBankAccount(clock);
        bankAccount.deposit(Money.fromInteger(10));
        bankAccount.withdraw(Money.fromInteger(10));
    }

    @Test
    public void shouldPrintTheBankAccountReport() {
        assertThat(reporter.print(bankAccount)).isEqualTo(expectedReport);
    }
}
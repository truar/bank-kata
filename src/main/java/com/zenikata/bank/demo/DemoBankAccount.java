package com.zenikata.bank.demo;

import com.zenikata.bank.domain.BankAccount;
import com.zenikata.bank.domain.Clock;
import com.zenikata.bank.domain.Money;
import com.zenikata.bank.domain.SGBankAccount;
import com.zenikata.bank.presenter.Reporter;
import com.zenikata.bank.presenter.StringReporter;

import java.io.PrintStream;
import java.math.BigDecimal;

public class DemoBankAccount {

    public static void main(String [] args) {

        final Clock clock = new Clock();
        final BankAccount bankAccount = new SGBankAccount(clock);
        bankAccount.deposit(Money.fromInteger(500));
        bankAccount.deposit(Money.fromInteger(100));
        bankAccount.withdraw(Money.fromInteger(300));
        bankAccount.deposit(Money.fromInteger(50));
        bankAccount.withdraw(Money.fromInteger(100));
        bankAccount.withdraw(Money.fromInteger(125));
        bankAccount.withdraw(new Money(new BigDecimal(100.50)));

        final Reporter reporter = new StringReporter();

        final PrintStream stream = System.out;
        stream.println(reporter.print(bankAccount));

    }

}

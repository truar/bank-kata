package com.zenikata.bank.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SGBankAccount implements BankAccount {

    private static final BigDecimal ZERO = new BigDecimal(0);

    private final Clock clock;
    private final List<Transaction> transactionsHistory = new ArrayList<>();

    public SGBankAccount(Clock clock) {
        this.clock = clock;
    }

    public void deposit(Money amountToDepose) {
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amountToDepose.amount(), clock.now());
        transactionsHistory.add(transaction);
    }

    public void withdraw(Money amountToWithdraw) {
        Transaction transaction = new Transaction(TransactionType.WITHDRAW, amountToWithdraw.amount().negate(), clock.now());
        transactionsHistory.add(transaction);
    }

    public List<Transaction> transactions() {
        return transactionsHistory;
    }

    public BigDecimal balance() {
        return transactionsHistory.stream()
                .map(Transaction::amount)
                .reduce(ZERO, BigDecimal::add);
    }

}

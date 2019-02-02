package com.zenikata.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private final TransactionType type;
    private final BigDecimal amount;
    private final LocalDateTime transactionDateTime;

    public Transaction(TransactionType type, BigDecimal amount, LocalDateTime transactionDateTime) {
        this.type = type;
        this.amount = amount;
        this.transactionDateTime = transactionDateTime;
    }

    public TransactionType type() {
        return type;
    }

    public BigDecimal amount() {
        return amount;
    }

    public LocalDateTime transactionDateTime() {
        return transactionDateTime;
    }
}

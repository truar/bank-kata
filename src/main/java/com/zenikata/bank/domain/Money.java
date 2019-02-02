package com.zenikata.bank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal amount;

    private Money(int value) {
        amount = new BigDecimal(value);
    }

    public static Money fromInteger(Integer value) {
        requireStrictlyPositive(value);
        return new Money(value);
    }

    private static void requireStrictlyPositive(Integer value) {
        if(value == null || value <= 0) {
            throw new IllegalArgumentException("Value should be strictly positive");
        }
    }

    public int amount() {
        return amount.intValue();
    }
}

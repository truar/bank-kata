package com.zenikata.bank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money fromInteger(Integer value) {
        requireStrictlyPositive(value);
        return new Money(new BigDecimal(value));
    }

    private static void requireStrictlyPositive(Integer value) {
        if(value == null || value <= 0) {
            throw new IllegalArgumentException("Value should be strictly positive");
        }
    }

    public BigDecimal amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.compareTo(money.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

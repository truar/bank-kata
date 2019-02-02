package com.zenikata.bank.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void shouldCreateMoneyFromAnInteger() {
        Money money = Money.fromInteger(5);
        assertThat(money.amount()).isEqualTo(new BigDecimal(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptZeroValue() {
        Money.fromInteger(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNullValue() {
        Money.fromInteger(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNegativeValue() {
        Money.fromInteger(-5);
    }

    @Test
    public void shouldBeEqual() {
        Money moneyFromInt = Money.fromInteger(5);
        Money moneyFromBigDecimal = new Money(new BigDecimal(5));
        assertThat(moneyFromInt).isEqualTo(moneyFromBigDecimal);
    }
}
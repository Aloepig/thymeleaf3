package com.myalley.thymeleaf3.domain.tdd;

import java.util.Objects;

public class Money implements Expression {

    final int amount;
    final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression times(int multi) {
        return new Money(amount * multi, currency);
    }

    @Override
    public Money reduce(String to, Bank bank) {
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) {
            return false;
        }
        return amount == money.amount && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

}

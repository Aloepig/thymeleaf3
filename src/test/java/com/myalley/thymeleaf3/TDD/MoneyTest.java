package com.myalley.thymeleaf3.TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class MoneyTest {

    @Test
    public void testMulti() {
        Money five = Money.dollar(5);
        Assertions.assertEquals(Money.dollar(10), five.times(2));
        Assertions.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        Assertions.assertEquals(Money.dollar(5), Money.dollar(5));
        Assertions.assertNotEquals(Money.dollar(6), Money.dollar(5));
        Assertions.assertEquals(Money.franc(5), Money.franc(5));
    }



    static class Money {
        private final int amount;
        private final String currency;

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

        Money times(int multi) {
            return new Money(amount * multi, currency);
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
    }

}
